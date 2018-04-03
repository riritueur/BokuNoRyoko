package richardperes.bokunoryoko;

/**
 * Created by Riritueur on 03/04/2018.
 */

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Riritueur on 20/02/2018.
 */

public class LieuAdapter extends BaseAdapter {

    private CreateJson mListD;
    //Le contexte dans lequel est présent notre adapter
    private Context mContext;
    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;

    public LieuAdapter(Context context, CreateJson aListD){
        mContext = context;
        mListD = aListD;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListD.size();
    }

    public Object getItem(int position) {
        return mListD.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout layoutItem; // ou ConstraintLayout ...Fonction du Layout défini
// Réutilisation des layouts
        if (convertView == null) {
//Initialisation de notre item à partir de "lieu_layout.xml"
            layoutItem = (ConstraintLayout) mInflater.inflate(R.layout.lieu_layout, parent, false);
        } else {
            layoutItem = (ConstraintLayout) convertView;
        }
        // Récupération des TextView du layout
        TextView tv_Nom = (TextView) layoutItem.findViewById(R.id.nomL);
        TextView tv_Theme = (TextView) layoutItem.findViewById(R.id.themeL);
        TextView tv_Description = (TextView) layoutItem.findViewById(R.id.descriptionL);

        ImageView iv_photal1 = (ImageView) layoutItem.findViewById(R.id.imageL1);
        //ImageView iv_photal2 = (ImageView) layoutItem.findViewById(R.id.imageL2);
        //ImageView iv_photal3 = (ImageView) layoutItem.findViewById(R.id.imageL3);

        // Renseignement des valeurs
        tv_Nom.setText(mListD.get(position).getNom());
        tv_Theme.setText(mListD.get(position).getTheme());
        tv_Description.setText(mListD.get(position).getDescription());

        new DownloadImageTask(iv_photal1).execute((mListD.get(position).getImages().get(0)));
        //new DownloadImageTask(iv_photal2).execute((mListD.get(position).getImages().get(1)));
        //new DownloadImageTask(iv_photal3).execute((mListD.get(position).getImages().get(2)));

        // TODO Coordonnées

        tv_Nom.setTag(position);


        ///On ajoute un listener
        tv_Nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer) v.getTag();
                sendListener(mListD.get(position), position);
            }
        });
        //On retourne l'item créé.

        return layoutItem;
    }

    //Interface pour écouter les événements sur le nom d'une personne
    public interface LieuAdapterListener {
        public void onClickNom(Lieu item, int position);
    }


    //Création d’écouteurs
    private ArrayList<LieuAdapterListener> mListListener = new ArrayList<>();

    //Pour ajouter un listener sur l’ adapter
    public void addListener(LieuAdapterListener aListener) {
        mListListener.add(aListener);
    }

    //permet de prévenir tous les listeners en même temps pour diffuser une information
    private void sendListener(Lieu item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }
}

