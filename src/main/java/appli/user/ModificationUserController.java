package appli.user;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import model.Utilisateur;
import session.SessionUtilisateur;
import javafx.scene.input.*;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificationUserController {
    private Utilisateur utilisateurSel;
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
    @FXML
    private Label emailModif;

    @FXML
    private TextField emailTextModif;

    @FXML
    private Label erreurModif;

    @FXML
    private Button modification;

    @FXML
    private Label nomModif;

    @FXML
    private TextField nomTextModif;

    @FXML
    private Label prenomModif;

    @FXML
    private TextField prenomTextModif;


    public void initData(Utilisateur utilisateur) {
        this.utilisateurSel = utilisateur;
        nomTextModif.setText(utilisateur.getNom());
        prenomTextModif.setText(utilisateur.getPrenom());
        emailTextModif.setText(utilisateur.getEmail());
    }


    @FXML
    void onHelloButtonClickModification(ActionEvent event) {
        nomTextModif.getText();
        prenomTextModif.getText();
        emailTextModif.getText();


        if (nomTextModif.getText().isEmpty() || prenomTextModif.getText().isEmpty() || emailTextModif.getText().isEmpty()) {
            erreurModif.setText("Veuillez remplir tous les champs !");
            return;
        }


        Utilisateur nouvelUtilisateur = new Utilisateur(utilisateurSel.getIdUtilisateur(), nomTextModif.getText(), prenomTextModif.getText(), emailTextModif.getText());
        utilisateurRepository.mettreAJourUtilisateur(nouvelUtilisateur);
        System.out.println("Inscription réussie !");
    }
}
