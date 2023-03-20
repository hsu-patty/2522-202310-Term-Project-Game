package ca.bcit.comp2522.termproje.game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    public Label testText;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onTestButtonClick() {
        testText.setText("This is a new test message");
    }
}