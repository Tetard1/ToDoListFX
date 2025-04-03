package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class AccueilController {

    @FXML
    private Button ButtonUser;

    @FXML
    void onHelloButtonClickButtonUser(ActionEvent event) throws IOException {
        StartApplication.changeScene("user/GestionUser");

    }

}
