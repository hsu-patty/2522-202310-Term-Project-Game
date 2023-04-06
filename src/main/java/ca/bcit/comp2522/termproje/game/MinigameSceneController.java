package ca.bcit.comp2522.termproje.game;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.util.Random;
/**
 * Mini-game scene controller class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */

public class MinigameSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private ImageView baseball;
    @FXML private ImageView bat;

    @FXML private Rectangle rectangle;

    private boolean swing = false;

    /**
     * Allows users to switch to home scene from mini-game scene.
     * @param event an Action Event that tells us the home button has been pressed
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

    /**
     * Starts the baseball mini-game by pitching the ball.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public void startGame(){
        baseball.setLayoutY(263.0);
        baseball.setLayoutX(292.0);
        Random rand = new Random();
        int x = rand.nextInt(3);
        double playerStat = (double) (HomeSceneController.player.getStrength() + HomeSceneController.player.getSpeed())
                / (HomeSceneController.player.getDays() * 2);
        if (playerStat < 1) {
            //creates a smaller hit box if players haven't been training
            rectangle.setHeight(rectangle.getHeight() * playerStat);
            rectangle.setLayoutY(rectangle.getLayoutY() + rectangle.getHeight());
        }
        // speeds up the baseball if players are unhappy or hungry
        double speedFactor = ((double) (HomeSceneController.player.getHappiness() / 5)
                + ((double) 1 / HomeSceneController.player.getHunger() / 10) / 2);

        Timeline ballTimeline = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {

            if (swing) {
                // makes the baseball go right, left or straight up after it's been hit
                if (x == 0) {
                baseball.setLayoutY(baseball.getLayoutY() - 3);
                baseball.setLayoutX(baseball.getLayoutX() - 1);
                } else if (x == 1) {
                    baseball.setLayoutY(baseball.getLayoutY() - 3);
                    baseball.setLayoutX(baseball.getLayoutX() + 1);
                } else {
                    baseball.setLayoutY(baseball.getLayoutY() - 3);
                }
            } else {
            baseball.setLayoutY(baseball.getLayoutY() + (3 / speedFactor));
            this.swing = false;
            }
        }));
        ballTimeline.setDelay(Duration.seconds(2));
        ballTimeline.setCycleCount(500);
        ballTimeline.play();
    }
    /**
     * Allows users to swing the baseball bat to hit the ball.
     */
    public void swing() {
        Rotate rotation = new Rotate();
        rotation.setPivotX(100);
        rotation.setPivotY(100);
        bat.getTransforms().add(rotation);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(rotation.angleProperty(), -360)));
        timeline.play();

        // if baseball is within the hit circle of box counts as a hit
        if (baseball.getLayoutY() >= rectangle.getLayoutY() - 10
                && baseball.getLayoutY() <= (rectangle.getLayoutY() + rectangle.getHeight() + 10)) {
            this.swing = true;
            HomeSceneController.player.increaseHits();
        }
    }

    public void runStartGame() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 10; i++) {
            scheduler.schedule(() -> startGame(), i * 10, TimeUnit.SECONDS);
        }
        scheduler.shutdown();
    }
//    public void playGame() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            startGame();
//        }
//    }
}
