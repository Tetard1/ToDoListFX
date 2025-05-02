package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import service.EmailService;
import database.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MotDePasseOublieController {
    @FXML
    private TextField emailField;


    @FXML
    private void envoyerCode() {
        String email = emailField.getText().trim();
        if (email.isEmpty()) {
            System.out.println("Veuillez entrer une adresse e-mail.");
            return;
        }

        // Connexion à la base de données
        try (Connection cnx = Database.getConnexion()) {
            if (cnx == null) {
                System.out.println("Connexion à la base de données échouée.");
                return;
            }


            String sql = "SELECT COUNT(*) FROM utilisateur WHERE email = ?";
            try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        String code = EmailService.genererCode();
                        EmailService.envoyerEmail(email, "Réinitialisation de mot de passe",
                                "Votre code de réinitialisation est : " + code);
                        System.out.println("Code envoyé à : " + email);
                        StartApplication.changeScene("accueil/ChangerMotDePasse");
                    } else {
                        System.out.println("Aucun compte associé à cette adresse e-mail.");
                    }
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println("Erreur lors de la vérification de l'e-mail : " + e.getMessage());
        }
    }
}
