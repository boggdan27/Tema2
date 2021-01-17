package ro.mta.se.lab.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/***
 * Aceasta clasa face conexiunea catre OpenWeatherMap.
 * Url-ul contine orasul si key-ul userului.
 * Daca exista conexiune, incep sa citesc rezultatul.
 *
 */



public class WeatherAPI {

    private static String key = "9ff6aa1d3acd4803645399998ab8f1c1";
    private static HttpURLConnection connection;
    String raspuns="";
    private String oras_cautat;

    public WeatherAPI(String oras_cautat) {
        this.oras_cautat = oras_cautat;
    }

    public String weather(String oras) throws IOException
    {
        URL url =new URL("http://api.openweathermap.org/data/2.5/weather?q="+oras+"&units=metric&appid="+ key);
        connection=(HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status=connection.getResponseCode();
        BufferedReader reader;
        String line;
        StringBuffer content= new StringBuffer();

        if(status !=200)
        {
            throw new RuntimeException("Error! HTTP GET Response code: " + status);
        }
        else
        {
            reader =new BufferedReader( new InputStreamReader(connection.getInputStream()));
            while ((line= reader.readLine())!=null)
            {
                content.append(line);
            }
            reader.close();
        }
        raspuns = content.toString();
        return raspuns;
    }
}



