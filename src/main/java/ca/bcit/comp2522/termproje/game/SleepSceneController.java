package ca.bcit.comp2522.termproje.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;
/**
 * Sleep scene controller class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */
public class SleepSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     * Switch to home scene from sleep scene.
     * @param event an Action Event that indicates the go home button has been pressed
     * @throws IOException if FXML file not found
     */
    public void switchToHome(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomeScene.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
        root = loader.load();
        HomeSceneController homeSceneController = loader.getController();
        homeSceneController.displayStats();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
