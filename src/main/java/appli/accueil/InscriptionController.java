package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import repository.UtilisateurRepository;
import model.Utilisateur;
import java.io.IOException;

public class InscriptionController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

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
    private Label mdpconfirmer;

    @FXML
    private PasswordField mdpconfirmerTexte;

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
        mdpconfirmerTexte.getText();

        if (nomText.getText().isEmpty() || prenomText.getText().isEmpty() || emailText.getText().isEmpty() || mdpTexte.getText().isEmpty() || mdpconfirmerTexte.getText().isEmpty()) {
            erreur.setText("Veuillez remplir tous les champs !");
            return;
        }

        if (!mdpTexte.getText().equals(mdpconfirmerTexte.getText())) {
            erreur.setText("Les mots de passe ne correspondent pas !");
            return;
        }

        if (utilisateurRepository.getUtilisateurParEmail(emailText.getText()) != null) {
            erreur.setText("Un utilisateur avec cet email existe déjà !");
            return;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Utilisateur nouvelUtilisateur = new Utilisateur(nomText.getText(), prenomText.getText(), emailText.getText(), encoder.encode(mdpTexte.getText()), "utilisateur");
        utilisateurRepository.ajouterUtilisateur(nouvelUtilisateur);
        System.out.println("Inscription réussie !");
    }
}

