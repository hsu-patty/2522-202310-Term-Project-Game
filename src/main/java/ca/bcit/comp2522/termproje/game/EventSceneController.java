package ca.bcit.comp2522.termproje.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Event scene controller class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */
public class EventSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Allows users to switch to home scene from all other event scenes.
     * @param event an Action Event that tells us the home button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
        root = loader.load();
        HomeSceneController homeSceneController = loader.getController();
        homeSceneController.displayName();
        homeSceneController.displayStats();
        homeSceneController.setButtons();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
