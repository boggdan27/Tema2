package ro.mta.se.lab.Controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import ro.mta.se.lab.Model.JsonFile;
import ro.mta.se.lab.Model.Oras;
import ro.mta.se.lab.Model.WeatherAPI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * Obtinerea informatiilor de la request si afisarea acestora in interfata.
 */


public class WeatherController {

    private ObservableList<String>tari = FXCollections.observableArrayList();
    private ObservableList<Oras> orase;

    public WeatherController(ObservableList<Oras> orase,Vector<String> tara) {
        this.orase = orase;
        this.tari.addAll(tara);
    }

    private String tara_selectata;
    private String oras_selectat;
    private String id;

    @FXML
    private Label temperatura;
    @FXML
    private Label temperatura_min;
    @FXML
    private Label temperatura_max;
    @FXML
    private Label wind;
    @FXML
    private Label presiune;
    @FXML
    private ComboBox<String> combo_country;
    @FXML
    private ComboBox<String> combo_city;


    /**
     * Se afiseaza tarile in combobox
     */
    @FXML
    private void selectCountry()
    {
        System.out.println(tari.size());
        combo_country.getItems().clear();
        for(int i=0;i<tari.size();i++)
        {
            combo_country.getItems().add(tari.get(i));
        }

    }

    /**
     * se memoreaza tara selectata
     */

    @FXML
    private void choseCountry()
    {
        tara_selectata = combo_country.getValue();
    }

    /**
     * Se verifica daca a fost selecatata o tara.
     * Daca da, se face afisarea oraselor din acea tara.
     */

    @FXML
    private void selectCity()
    {
        if(tara_selectata != null)
        {
            combo_city.getItems().clear();
            for(int i=0;i<orase.size();i++)
            {
                if(tara_selectata.equals(orase.get(i).getTara()))
                {
                    combo_city.getItems().add(orase.get(i).getNume());
                }
            }
        }


    }

    /**
     * Se memoreaza tara selectata
     */
    @FXML
    private void choseCity()
    {
        oras_selectat=combo_city.getValue();
    }

    /**
     * Se verifica sa fie amandoua comboboxuri selectate.
     * Se face un request pentru a obtine datele despre vreme.
     * Se foloseste clasa JsonFile pentru a obtine valorile necesare.
     * Se scriu datele in fisier.
     */

    @FXML
    public void search() throws IOException
    {
        if(tara_selectata != null && oras_selectat != null)
        {
            String orass = null;
            String taraa = null;
            int ok=0;
            for(int i =0;i<orase.size();i++)
            {
                if(orase.get(i).getTara().equals(tara_selectata) && orase.get(i).getNume().equals(oras_selectat))
                {
                    id = orase.get(i).getId();
                    orass = orase.get(i).getNume();
                    taraa = orase.get(i).getTara();
                    ok=1;
                }
            }
            WeatherAPI request = new WeatherAPI(oras_selectat);
            JsonFile json = new JsonFile(request.weather(oras_selectat));

            temperatura.setText("Temperatura: "+ json.get_temp() +"\u00B0"+"C");
            temperatura_max.setText("Maxim: "+ json.get_temp_max() +"\u00B0"+"C" );
            temperatura_min.setText("Minim: "+ json.get_temp_min() +"\u00B0"+"C" );
            wind.setText("Vantul este " + json.get_wind_speed());
            presiune.setText("Presiunea este "+ json.get_presiune());

            if(ok == 1)
            {
                File log = new File ("./src/main/resources/output.txt");
                if(log.exists()==false)
                {
                    log.createNewFile();
                }


                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                out.append("oras "+ orass + " tara " + taraa + " temperatura " + json.get_temp().toString() + " temp maxim " + json.get_temp_max().toString() +" temp minim "+ json.get_temp_min().toString()+ " wind "+ json.get_wind_speed()+" presiune "+json.get_presiune()+"\n");
                out.close();
            }

        }


    }
}
