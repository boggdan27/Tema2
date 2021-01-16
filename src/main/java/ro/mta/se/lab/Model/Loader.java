package ro.mta.se.lab.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.Model.Oras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Loader
{
    private Vector<String> tara = new Vector<String>(100);
    private ObservableList<Oras> locatii = FXCollections.observableArrayList();
   // String fisier = "./src/main/resources/in.txt";


    public Loader() throws FileNotFoundException {
        citire_orase();
    }

    public int check(Vector<String> t, String p)
    {
        int ok = 0;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).equals(p)) {
                ok++;
                break;
            }
        }
        return ok;
    }
    private void citire_orase() throws FileNotFoundException
    {
        File input_File = new File("./src/main/resources/in.txt");

        Scanner cuv = new Scanner(input_File);
        while(cuv.hasNextLine())
        {
            String data = cuv.nextLine();

            String[] splituit = data.split("\n");
           // System.out.println(arrSplit[0] ); // split0 e o linie



            for (int i = 0; i < splituit.length; i++)
            {
                    String[] littleparts = splituit[i].split("\t");
                    // System.out.println(littleparts[0] +"____"+littleparts[1]);

                    Oras aux = new Oras(littleparts[0], littleparts[1], littleparts[2], littleparts[3], littleparts[4]);
                    locatii.add(aux);

                   if(check(tara,littleparts[4])==0)
                   {
                       tara.add(littleparts[4]);
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
