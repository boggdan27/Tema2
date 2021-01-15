package ro.mta.se.lab.Model;

public class Oras {
    String nume;
    String tara;
    int id;
    double lat;
    double lon;

    public Oras(String nume, String tara, int id, double lat, double lon) {
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

    public int getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

}
