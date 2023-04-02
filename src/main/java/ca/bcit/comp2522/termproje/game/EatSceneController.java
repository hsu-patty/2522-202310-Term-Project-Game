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
 * Eat scene controller class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */
public class EatSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

//    public void switchToHome(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomeScene.fxml")));
//        HomeSceneController homeSceneController = new FXMLLoader(getClass().getResource("HomeScene.fxml")).getController();
//        homeSceneController.displayStats();
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    /**
     * Allows users to switch to home scene from eat scene.
     * @param event an Action Event that tells us what action is being taken
     * @throws IOException if FXML scene is not found
     */
    public void switchToHome(final ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
        root = loader.load();
        HomeSceneController homeSceneController = loader.getController();
        homeSceneController.displayStats();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
