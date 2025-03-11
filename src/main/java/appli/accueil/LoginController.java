package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

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
        erreur.setVisible(false);
        if (mdpTexte.getText().equals("") || emailText.getText().equals("")) {
            erreur.setVisible(true);
            erreur.setText("Erreur de connexion");
        }
    }

    @FXML
    void onHelloButtonClickInscription(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Inscription");
    }
    @FXML
    void onHelloButtonClickMdp(ActionEvent event) {

    }





}
