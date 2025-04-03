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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {
    @FXML
    private Button disable;

    @FXML
    private TableView<Utilisateur> tableauUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("GestionUserController");
        String[][] colonnes = {
                {"Id Utilisateur", "idUtilisateur"},
                {"Nom", "nom"},
                {"Prénom", "prenom"},
                {"Email", "email"},
                {"Rôle", "role"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            //Création de la colonne avec le titre
            TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);
            //Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(
                    new PropertyValueFactory<Utilisateur, String>(colonnes[i][1]));
            //Ajout de la colonne dans notre tableau
            tableauUser.getColumns().add(maCol);
        }
        UtilisateurRepository rep = new UtilisateurRepository();

        tableauUser.getItems().addAll(rep.getTousLesUtilisateurs());
    }


    @FXML
    void onHelloButtonClickDisable(ActionEvent event) throws IOException {
        Utilisateur utilisateurSelectionne = tableauUser.getSelectionModel().getSelectedItem();

        if (utilisateurSelectionne != null) {
            UtilisateurRepository rep = new UtilisateurRepository();
            rep.supprimerUtilisateurParEmail(utilisateurSelectionne.getEmail());


        }
    }
}


