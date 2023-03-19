module ca.bcit.comp2522.termproje.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproje.game to javafx.fxml;
    exports ca.bcit.comp2522.termproje.game;
}