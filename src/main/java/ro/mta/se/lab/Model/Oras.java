package ro.mta.se.lab.Model;

/**
 * Clasa oras contine toate informatiile pentru orasele aflate in in.txt
 */

public class Oras {
    String nume;
    String tara;
    String id;
    String lat;
    String lon;

    public Oras(String id, String nume,  String lon, String lat, String tara) {
        this.nume = nume;
        this.tara = tara;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNume() {
        return nume;
    }

    public String getTara() {
        return tara;
    }

    public String getId() {
        return id;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
