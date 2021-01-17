package ro.mta.se.lab.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.Model.Oras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Loader citeste din in.txt si face o lista de orase.
 * Functia de check verifica daca exista o tara deja in lista.
 */

public class Loader
{
    private Vector<String> tara = new Vector<String>(100);
    private ObservableList<Oras> locatii = FXCollections.observableArrayList();
   // String fisier = "./src/main/resources/in.txt";


    public Loader() throws FileNotFoundException {
        citire_orase();
    }


    /**
     * Verificare daca exista deja o tara in lista
     */
    public int check(Vector<String> t, String p)
    {
        int ok = 0;
        for (int i = 0; i < t.size(); i++)
        {
            if (t.get(i).equals(p))
            {
                ok=1;
                break;
            }
        }
        return ok;
    }

    /**
     * Citire din fisier si inserarea in lista de orase
     */
    private void citire_orase() throws FileNotFoundException
    {
        File input_File = new File("./src/main/resources/in.txt");

        Scanner cuv = new Scanner(input_File);
        while(cuv.hasNextLine())
        {
            String data = cuv.nextLine();

            String[] splituit = data.split("\n");
           // System.out.println(cuvinte[0] ); // split0 e o linie



            for (int i = 0; i < splituit.length; i++)
            {
                    String[] cuvinte = splituit[i].split("\t");
                    // System.out.println(cuvinte[0] +"____"+cuvinte[1]);

                    Oras aux = new Oras(cuvinte[0], cuvinte[1], cuvinte[2], cuvinte[3], cuvinte[4]);
                    locatii.add(aux);

                   if(check(tara,cuvinte[4])==0)
                   {
                       tara.add(cuvinte[4]);
                   }
            }
        }
        System.out.println(this.locatii.size()+" "+this.tara.size());

    }

    public Vector<String> getTara() {
        return tara;
    }

    public ObservableList<Oras> getLocatii() {
        return locatii;
    }
}
