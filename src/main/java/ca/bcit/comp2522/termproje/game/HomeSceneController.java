package ca.bcit.comp2522.termproje.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
/**
 * Home scene controller class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */
public class HomeSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private static Player player;

    /**
     * Allows users to switch to work scene from home scene and will call the player work method.
     * @param event an Action Event that tells us the work button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToWork(final ActionEvent event) throws IOException {
        player.work();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WorkScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Allows users to switch to eat scene from home scene and will call the player eat method.
     * @param event an Action Event that tells us the eat button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToEat(final ActionEvent event) throws IOException {
        player.eat();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EatScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Allows users to switch to sleep scene from home scene and will call the player sleep method.
     * @param event an Action Event that tells us the sleep button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToSleep(final ActionEvent event) throws IOException {
        player.sleep();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SleepScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Allows users to switch to work scene from home scene and will call the player work method.
     * @param event an Action Event that tells us the work button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToTraining(final ActionEvent event) throws IOException {
        player.trainPlayer();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TrainingScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Allows users to switch to mini-game scene from home scene and will call the mini-game method.
     * @param event an Action Event that tells us the mini game button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToMiniGame(final ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MiniGameScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Allows users to switch to relationship scene from home scene and will call the player hangout method.
     * @param event an Action Event that tells us the hangout button has been pressed
     * @throws IOException if FXML scene is not found
     */
    public void switchToRelationship(final ActionEvent event) throws IOException {
        player.hangout();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RelationshipScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    Label nameLabel;
    @FXML
    Label speedLabel;
    @FXML
    Label strengthLabel;
    @FXML
    Label energyLabel;
    @FXML
    Label happinessLabel;
    @FXML
    Label moneyLabel;
    @FXML
    Label hungerLabel;
    @FXML
    Label daysLabel;
    /**
     * Displays player username on screen.
     */
    public void displayName() {
        nameLabel.setText("Hello " + player.getName() + "!");
    }
    /**
     * Displays player's stats on screen.
     */
    public void displayStats() {
        speedLabel.setText("Speed : " + player.getSpeed());
        strengthLabel.setText("Strength : " + player.getStrength());
        energyLabel.setText("Energy : " + player.getEnergy());
        happinessLabel.setText("Happiness : " + player.getHappiness());
        moneyLabel.setText("Money : " + player.getMoney());
        hungerLabel.setText("Hunger : " + player.getHunger());
        daysLabel.setText("Days passed : " + player.getDays());
    }
    /**
     * Creates a new instance of the player class.
     * @param name player's inputted name
     */
    public void createPlayer(final String name) {
        this.player = new Player();
        player.setName(name);
    }

    public void loadPlayer(final String name, final int speed, final int strength, final int energy,
                           final int happiness, final int money, final int hunger, final int days) {
        this.player = new Player(name, speed, strength, energy, happiness, money, hunger, days);
    }
    @FXML
    Button eatButton;
    @FXML
    Button sleepButton;
    @FXML
    Button workButton;
    @FXML
    Button trainButton;
    @FXML
    Button hangoutButton;
    @FXML
    Button minigameButton;


    public void setButtons() {
        if (player.getEnergy() <= 0) {
            eatButton.setDisable(true);
            workButton.setDisable(true);
            trainButton.setDisable(true);
            hangoutButton.setDisable(true);
        } else {
            eatButton.setDisable(false);
            workButton.setDisable(false);
            trainButton.setDisable(false);
            hangoutButton.setDisable(false);
        }

//        if (player.getDays() % 5 == 0 || player.getDays() == 0) {
//            minigameButton.setDisable(false);
//        } else {
//            minigameButton.setDisable(true);
//        }
    }
    public void switchToMiniGamePatty(final ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MiniGameScenePatty.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void saveData() throws IOException {
        FileWriter fw = new FileWriter("src/main/java/ca/bcit/comp2522/termproje/game/save.txt");
        fw.write(player.getName() + "\r\n");
        fw.write(player.getSpeed() + "\r\n");
        fw.write(player.getStrength() + "\r\n");
        fw.write(player.getEnergy() + "\r\n");
        fw.write(player.getHappiness() + "\r\n");
        fw.write(player.getMoney() + "\r\n");
        fw.write(player.getHunger() + "\r\n");
        fw.write(player.getDays() + "\r\n");
        fw.close();
    }
}
