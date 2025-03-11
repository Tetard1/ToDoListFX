module appli {
    requires javafx.controls;
    requires javafx.fxml;


    opens appli to javafx.fxml;
    exports appli;
    opens appli.accueil to javafx.fxml;
    exports appli.accueil;

}