package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class ChangerMotDePasseController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private void validerMotDePasse() throws IOException {
        String password = passwordField.getText();
        String confirm = confirmPasswordField.getText();

        if (!password.equals(confirm)) {
            System.out.println("Les mots de passe ne correspondent pas.");
            return;
        }

        // Mettre à jour le mot de passe en BDD
        System.out.println("Mot de passe mis à jour !");
        StartApplication.changeScene("accueil/Login");

    }
}
