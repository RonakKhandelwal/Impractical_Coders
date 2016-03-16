package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronak on 8/10/15.
 */
public class ShowMenu {

    // Width and height of image in pixels
    private static  double IMG_WIDTH = 368;
    private static  double IMG_HEIGHT = 500;

    private static  int NUM_OF_IMGS ;
    private static final int SLIDE_FREQ = 4; // in secs

    public static void showMenu(ImageView imageViews[],int noi,double wi,double hi){
        Stage window = new Stage();
        NUM_OF_IMGS=noi;
        IMG_WIDTH=wi;
        IMG_HEIGHT=hi;
        HBox hb = new HBox();
        hb.getChildren().addAll(imageViews);
        Pane clipPane = new Pane();
        clipPane.setClip(new Rectangle(IMG_WIDTH,IMG_HEIGHT));
        clipPane.getChildren().addAll(hb);
        Scene sc=new Scene(clipPane,IMG_WIDTH,IMG_HEIGHT);
        window.setScene(sc);
        window.show();
        startAnimation(hb);
    }

    private static void startAnimation(final HBox hbox) {

        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), hbox);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), hbox);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }
        Timeline anim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));

        anim.setCycleCount(Timeline.INDEFINITE);
        anim.playFromStart();
    }
}
