package richardperes.bokunoryoko;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by riritueur on 10/03/2018.
 */

public class CreateJson {

    List<Lieu> list;
    public CreateJson(){
        list = new ArrayList<Lieu>();
    }

    public int size(){
        return list.size();
    }

    public Lieu get(int pos){
        return list.get(pos);
    }

    public void construireListe(Context context){


        // Création de la liste des recettes
        try {
            // Récupération du fichier json
            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            // Récupération des recettes
            for(int i = 0; i < jsonArray.length(); i++) {
                list.add(getRecetteFromJSONObject(jsonArray.getJSONObject(i),context));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private Lieu getRecetteFromJSONObject(JSONObject jsonObject, Context context) throws JSONException {

        String nom = jsonObject.getString("nom");
        String theme = jsonObject.getString("theme");
        String description = jsonObject.getString("description");

        double latitude = jsonObject.getInt("lat");
        double longitude = jsonObject.getInt("long");

        ArrayList<String> urls = new ArrayList<String>();

        for(int i = 0; i < jsonObject.getJSONArray("photo").length(); i++)
            urls.add(jsonObject.getJSONArray("photo").getJSONObject(i).toString());

        Lieu lieu = new Lieu(nom, theme, description, latitude, longitude, urls);
        return lieu;
    }


    //lecture du fichier en string
    private  String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("jpy.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }
}