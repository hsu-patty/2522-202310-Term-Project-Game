package ca.bcit.comp2522.termproje.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
        homeSceneController.setButtons();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loadGame(final ActionEvent event) throws IOException {
        try {
            File file = new File("src/main/java/ca/bcit/comp2522/termproje/game/save.txt");
            Scanner dataScanner = new Scanner(new File(file.toURI()));
            String username = dataScanner.nextLine();
            int userSpeed = dataScanner.nextInt();
            int userStrength = dataScanner.nextInt();
            int userEnergy = dataScanner.nextInt();
            int userHappiness = dataScanner.nextInt();
            int userMoney = dataScanner.nextInt();
            int userHunger = dataScanner.nextInt();
            int days = dataScanner.nextInt();
            int hits = dataScanner.nextInt();
//            System.out.printf("%s, %d, %d, %d, %d, %d, %d, %d",
//                    username, userSpeed, userStrength, userEnergy, userHappiness, userMoney,
//                    userHunger, days);
            dataScanner.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
            root = loader.load();
            HomeSceneController homeSceneController = loader.getController();
            homeSceneController.loadPlayer(username, userSpeed, userStrength, userEnergy, userHappiness, userMoney,
                    userHunger, days, hits);
            homeSceneController.displayName();
            homeSceneController.displayStats();
            homeSceneController.setButtons();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (FileNotFoundException e) {
            System.out.println("Item not found");
        }

    }
}
