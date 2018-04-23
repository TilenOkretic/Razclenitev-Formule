package tileno;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /**
     * Spremenljivke, ki so komponente programa
     */

    @FXML
    private Label progress;

    @FXML
    private TextField input;

    @FXML
    private TextArea output;


    /**
     * Inicializacija
     * Tukaj samo nastavim da polje izpisa se ne more spreminjati rocno
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        output.setEditable(false);
    }


    /**
     * Metoda, ki je klicana ob pritisku gumba
     *
     * Preprosto ob pritisku gumba poregleda ce je 'input' veljavna formula in poslje formulo v obdelovanje nato
     * pa izpise stevilo posameznih atomov
     *
     * @param actionEvent
     */
    public void onAction(ActionEvent actionEvent) {

        if(!input.getText().equals("")){

            StringBuilder _out = new StringBuilder();

            FormulaManager fm = new FormulaManager(input.getText());

            progress.setText("Loading...");

            for(Map.Entry<String,Integer> e : fm.getFormulaMap().entrySet()){
                _out.append(e.getKey()).append(" ").append(e.getValue()).append(" \n");
            }

            output.setText(_out.toString());

            progress.setText("Done!");
        }

    }
}
