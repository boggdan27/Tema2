package ro.mta.se.lab;


    import javafx.application.Application;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import ro.mta.se.lab.Controller.WeatherController;
    import ro.mta.se.lab.Model.Oras;
    import ro.mta.se.lab.Model.Loader;

    import java.io.IOException;

public class Main extends Application
{
    private ObservableList<Oras> lista_orase = FXCollections.observableArrayList();



    public static void main(String[] args)
    {
         launch(args);
    }

    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        Loader load = new Loader();

       // System.out.println(load.getTara());
        loader.setLocation(this.getClass().getResource("/View/Weather.fxml"));
        lista_orase = load.getLocatii();
        loader.setController(new WeatherController(lista_orase,load.getTara()));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }
}


