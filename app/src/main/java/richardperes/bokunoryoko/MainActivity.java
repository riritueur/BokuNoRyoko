package richardperes.bokunoryoko;

<<<<<<< HEAD
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
=======
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
>>>>>>> 23899db40bfa2f10e0b172e5c3b1551f201d53a5

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LieuAdapter.LieuAdapterListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.jason);

        CreateJson list= new CreateJson();
        list.construireListe(this);
        LieuAdapter adapter = new LieuAdapter(this, list);
        ListView listV = (ListView) findViewById(R.id.malv);
        listV.setAdapter(adapter);
        //adapter.addListener(this);

    }


    @Override
    public void onClickNom(Lieu item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Diplome");
        builder.setMessage("Vous avez cliqué sur : " + item.getNom());
        builder.setPositiveButton("Ok blk", null);
        builder.show();
=======
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
>>>>>>> 23899db40bfa2f10e0b172e5c3b1551f201d53a5
    }
}
