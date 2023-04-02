package ca.bcit.comp2522.termproje.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Main screen controller class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */
public class MainScreenController {

    @FXML
    TextField nameTextField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Starts the game.
     * @param event Action Event that says the start game button has been pressed.
     * @throws IOException if designated FXML file is not found
     */
    public void startGame(final ActionEvent event) throws IOException {
        String username = nameTextField.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
        root = loader.load();

        HomeSceneController homeSceneController = loader.getController();
        homeSceneController.createPlayer(username);
        homeSceneController.displayName();
        homeSceneController.displayStats();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
