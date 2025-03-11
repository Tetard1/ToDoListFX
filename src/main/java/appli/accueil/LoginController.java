package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button connexion;

    @FXML
    private Label email;

    @FXML
    private TextField emailText;

    @FXML
    private Label erreur;

    @FXML
    private Button inscription;

    @FXML
    private Label mdp;

    @FXML
    private PasswordField mdpTexte;

    @FXML
    private Button mdpoublie;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClickConnexion(ActionEvent event) {
        mdpTexte.getText();
        emailText.getText();
        System.out.println(emailText.getText());
        System.out.println(mdpTexte.getText());
    }

    @FXML
    void onHelloButtonClickInscription(ActionEvent event) {

    }
    @FXML
    void onHelloButtonClickMdp(ActionEvent event) {

    }





}
