package ca.bcit.comp2522.termproje.game;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MinigameSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private ImageView baseball;
    @FXML private ImageView bat;

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
        int counter = 0;
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(baseball);
        while (counter < 10) {
            translate.setDelay(Duration.seconds(0.75));
            translate.setByY(250);
            translate.setCycleCount(1);
            translate.setDuration(Duration.millis(1000));
            translate.play();
            baseball.setTranslateX(0);
            baseball.setTranslateY(0);
            counter ++;
        }
    }

    public void swing() {
//        RotateTransition rotate = new RotateTransition();
//        Rotate rotation = new Rotate();
//        rotation.setPivotX(223);
//        rotation.setPivotY(337);
//
//        rotate.setNode(bat);
//        rotate.setDuration(Duration.millis(500));
//        rotate.setCycleCount(1);
////        rotate.setByAngle(360);
//        rotate.setInterpolator(Interpolator.LINEAR);
//        bat.getTransforms().add(rotation);
//        rotation.setAngle(rotation.getAngle() + 50);
//        rotate.play();

        if (baseball.getY() >= 340 && baseball.getY() <= 360) {
            baseball.setTranslateY(-600);
            baseball.setTranslateX(200);
        }
    }
}
