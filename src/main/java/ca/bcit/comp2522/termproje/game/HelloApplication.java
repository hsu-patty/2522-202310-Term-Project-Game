package ca.bcit.comp2522.termproje.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
/**
 * Hello Application class.
 * @author Patty Hsu & Tim lee
 * @version 202310
 */
public class HelloApplication extends Application {

    /**
     * Allows the game to greet the user via their input.
     * @param stage the Stage that we are displaying the users name in
     */
    @Override
    public void start(final Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScreen.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Rising Star");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
