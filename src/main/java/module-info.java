module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires spring.security.crypto;

    opens  model to javafx.fxml, javafx.base;
    exports model to javafx.fxml, javafx.base;

    opens appli to javafx.fxml;
    exports appli;
    opens appli.accueil to javafx.fxml;
    exports appli.accueil;

    opens appli.user to javafx.fxml;
    exports appli.user;



}