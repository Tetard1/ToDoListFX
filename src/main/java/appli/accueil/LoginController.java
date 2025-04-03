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
import model.Utilisateur;
import session.SessionUtilisateur;

import java.io.IOException;

public class LoginController {

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
    private Button mdpoublie;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClickConnexion(ActionEvent event) throws IOException {
        mdpTexte.getText();
        emailText.getText();
        if (emailText.getText().isEmpty() || mdpTexte.getText().isEmpty()) {
            erreur.setText("Veuillez remplir tous les champs !");
            return;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(emailText.getText());
        if (utilisateur != null && encoder.matches(mdpTexte.getText(), utilisateur.getMotDePasse())) {
            System.out.println("Connexion réussie pour : " + utilisateur.getNom());
            SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);
            erreur.setVisible(false);
            StartApplication.changeScene("accueil/Accueil");
        } else {
            System.out.println("Échec de la connexion. Email ou mot de passe incorrect.");
            erreur.setText("Email ou mot de passe incorrect.");
            erreur.setVisible(true);
        }


    }

    @FXML
    void onHelloButtonClickInscription(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Inscription");
    }
    @FXML
    void onHelloButtonClickMdp(ActionEvent event) {

    }
    @FXML
    protected void Deconneixon() {
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");
        // Redirection vers la page de connexion
    }





}
