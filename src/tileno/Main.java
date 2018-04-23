package tileno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Staticne spremenljivke ali konstante za graficni vmesnik
     * TITLE je naslov programa
     * WIDTH,HEIGHT sta visina in sirina okna
     */
    private static final String TITLE = "Formula Manager";
    private static final int WIDTH = 600,HEIGHT = 475;


    public static void main(String[] args) {
        /**
         * Metoda za zagon programa
         */
        launch(args);
    }


    /**
     * Pripravimo sceno ki se nalozi preko gfx.fxml datoteke
     * in povemo kateri razred je krmilnik(Controller) nasega programa
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gfx.fxml"));
        primaryStage.setTitle(TITLE);
        Scene scene = new Scene(root, WIDTH,HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
