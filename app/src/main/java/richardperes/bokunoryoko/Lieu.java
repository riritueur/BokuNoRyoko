package richardperes.bokunoryoko;

import android.media.Image;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Riritueur on 03/04/2018.
 */

public class Lieu {
    private String nom, description, theme;
    private double longitude, latitude;
    private ArrayList<String> images;

    public Lieu(String nom, String description, String theme, double longitude, double latitude, ArrayList<String> urls) {
        this.nom = nom;
        this.description = description;
        this.theme = theme;
        this.longitude = longitude;
        this.latitude = latitude;

        this.images = urls;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getTheme() {
        return theme;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

}
