package ro.mta.se.lab.Model;


import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;
import  org.json.JSONArray;
import org.json.JSONObject;

/**
 * Aceasta clasa este folosita in WeatherController.
 * Obtin informatiile de la raspunsul requestului.
 */

public class JsonFile {


    String file;

    public JsonFile(String file) {
        this.file = file;
    }

    public String get_temp_min()
    {
        JSONObject aux=new JSONObject(file);
        return  String.valueOf(aux.getJSONObject("main").getFloat("temp_min"));
    }

    public String get_temp_max()
    {
        JSONObject aux=new JSONObject(file);
        return  String.valueOf(aux.getJSONObject("main").getFloat("temp_max"));
    }

    public String get_temp()
    {
        JSONObject aux=new JSONObject(file);
        return  String.valueOf(aux.getJSONObject("main").getFloat("temp"));

    }

    public String get_wind_speed()
    {
        JSONObject aux=new JSONObject(file);
        return  String.valueOf(aux.getJSONObject("wind").getFloat("speed"));
    }
    public String get_presiune()
    {
        JSONObject aux=new JSONObject(file);
        return  String.valueOf(aux.getJSONObject("main").getFloat("pressure"));
    }


}
