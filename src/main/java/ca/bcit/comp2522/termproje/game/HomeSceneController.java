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

public class HomeSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private static Player player;

    public void switchToWork(ActionEvent event) throws IOException {
        player.work();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WorkScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEat(ActionEvent event) throws IOException {
        player.eat();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EatScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSleep(ActionEvent event) throws IOException {
        player.sleep();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SleepScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTraining(ActionEvent event) throws IOException {
        player.trainPlayer();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TrainingScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMiniGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MiniGameScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRelationship(ActionEvent event) throws IOException {
        player.hangout();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RelationshipScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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

    public void displayName() {
        nameLabel.setText("Hello " + player.getName() + "!");
    }

    public void displayStats() {
        speedLabel.setText("Speed : " + player.getSpeed());
        strengthLabel.setText("Strength : " + player.getStrength());
        energyLabel.setText("Energy : " + player.getEnergy());
        happinessLabel.setText("Happiness : " + player.getHappiness());
        moneyLabel.setText("Money : " + player.getMoney());
        hungerLabel.setText("Hunger : " + player.getHunger());
    }

    public void createPlayer(String name) {
        this.player = new Player();
        player.setName(name);
    }
}
