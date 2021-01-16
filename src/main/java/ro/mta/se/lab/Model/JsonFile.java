package ro.mta.se.lab.Model;


import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;
import  org.json.JSONArray;
import org.json.JSONObject;

public class JsonFile {

    //il folosesc in controller
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
    public String get_action()
    {
        JSONObject aux=new JSONObject(this.file);
        JSONArray weather=(JSONArray)aux.get("weather");
        JSONObject weather1=(JSONObject)weather.get(0);
        return (String)weather1.get("main");
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
