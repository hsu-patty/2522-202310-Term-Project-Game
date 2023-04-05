package ca.bcit.comp2522.termproje.game;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class MinigameSceneControllerPatty {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private ImageView baseball;
    @FXML private ImageView bat;

    public boolean swing = false;

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

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(baseball);
//        translate.setByY(250);
//        translate.setCycleCount(10);
//        translate.setDuration(Duration.millis(1000));
//        translate.play();
//
//
//    }

    public void startGame() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        Timeline ballTimeline = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {

            if (swing) {
                if (x == 0) {
                baseball.setLayoutY(baseball.getLayoutY() -3);
                baseball.setLayoutX(baseball.getLayoutX()-1);}
                else if (x == 1) {
                    baseball.setLayoutY(baseball.getLayoutY() -3);
                    baseball.setLayoutX(baseball.getLayoutX() + 1);}
                else {
                    baseball.setLayoutY(baseball.getLayoutY() -3);
                }
            }
            else {
            baseball.setLayoutY(baseball.getLayoutY() + 1);
            this.swing = false;}
        }));
//        KeyFrame end = new KeyFrame(Duration.seconds(2), new KeyValue(baseball.yProperty(), 500));
//        ballTimeline.getKeyFrames().add(end);
        ballTimeline.setCycleCount(500);
        System.out.println(this.swing);
        ballTimeline.play();

    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public void swing() {
//        RotateTransition rotate = new RotateTransition();
//        Rotate rotation = new Rotate();
//        rotation.setPivotX(223);
//        rotation.setPivotY(337);
//
//        rotate.setNode(bat);
//        rotate.setDuration(Duration.millis(500));
//        rotate.setCycleCount(1);
//        rotate.setByAngle(270);
//        rotate.setInterpolator(Interpolator.LINEAR);
////        bat.getTransforms().add(rotation);
////        rotation.setAngle(rotation.getAngle() + 50);
//        rotate.play();
        Rotate rotation = new Rotate();
        rotation.setPivotX(100);
        rotation.setPivotY(100);
//        rotation.pivotXProperty().bind(bat.xProperty());
//        rotation.pivotXProperty().bind(bat.yProperty());
        bat.getTransforms().add(rotation);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(rotation.angleProperty(), -360)));
        timeline.play();
//        bat.getTransforms().add(new Rotate(270,100, 100));

        if (baseball.getLayoutY() >= 330 && baseball.getLayoutY() <= 370) {
            this.swing = true;
        }
//        this.swing = true;
    }
}
