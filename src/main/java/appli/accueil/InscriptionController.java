package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InscriptionController {


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
    private Label nom;

    @FXML
    private TextField nomText;

    @FXML
    private Label prenom;

    @FXML
    private TextField prenomText;

    @FXML
    private Label welcomeText;


    @FXML
    void onHelloButtonClickConnexion(ActionEvent event) throws IOException {
            StartApplication.changeScene("accueil/Login");
    }

    @FXML
    void onHelloButtonClickInscription(ActionEvent event) {
        nomText.getText();
        prenomText.getText();
        mdpTexte.getText();
        emailText.getText();
        System.out.println(emailText.getText());
        System.out.println(mdpTexte.getText());
        System.out.println(nomText.getText());
        System.out.println(prenomText.getText());

        if (!emailText.equals(email.getText()) || !mdpTexte.equals(mdp.getText()) || !nomText.equals(nom.getText()) || !prenomText.equals(prenom.getText())) {
            erreur.setText("veuillez rentrer toute les informations");

        } else {
            erreur.setText(" ");
            System.out.println("Inscription réussi");
        }
    }

}
