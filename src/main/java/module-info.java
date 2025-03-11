module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens appli to javafx.fxml;
    exports appli;
    opens appli.accueil to javafx.fxml;
    exports appli.accueil;

}