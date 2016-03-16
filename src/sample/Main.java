package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    Stage window;
    Scene scene;
    String mediaurl="file:/sample/iphone6.wmv";
    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        //All the components








        Label label= new Label();
        label.setText(" Find Places to eat nearby");
        Label mast=new Label("Bored of the normal mess food?\nHelp us Help You Find Something Better!!!");
        mast.wrapTextProperty();
        Pane p=new Pane();

        p.getChildren().addAll(mast);
        p.getStylesheets().add("sample/ChoiceLables.css");


        VBox left=new VBox();
        left.getChildren().add(label);
        left.setAlignment(Pos.CENTER);
        String a="Coffee Valley",b1= "Eye Of The Tiger", c="Snack Shack";
        BorderPane bp=new BorderPane();
        bp.setCenter(left);
        bp.setTop(p);

        ChoiceBox <String> cb=new ChoiceBox<>();
        cb.getItems().addAll(a,b1,c);
        Button b=new Button();
        b.setText("Go");
        b.setOnAction(e -> getChoice(cb));
       /* Button b1=new Button("Coffee Valley");
        b1.setText("Coffee Valley");
        Button b2=new Button("Eye Of The Tiger");
        Button b3=new Button("China Valley");
        //Button b4=new Button();*/
        //b1.setOnAction(e -> CoffeeValley.display());
        //cb.getItems().add(b1);
        left.getChildren().addAll(cb, b);
        left.setMargin(cb, new Insets(2, 2, 2, 2));
        left.setMargin(label,new Insets(2,2,2,2));
        left.setMargin(b,new Insets(2,2,2,2));


       /* BorderPane br=new BorderPane();
        br.setLeft(left);*/

        scene=new Scene(bp,480,473);
        scene.getStylesheets().add("sample/DarkTheme.css");
        window.setScene(scene);
        window.show();

    }
    private static void getChoice(ChoiceBox<String> cb){
        String text = cb.getValue();
        if (text.equals("Coffee Valley")){
            new CoffeeValley().display();
        }

        if (text.equals("Eye Of The Tiger")){
            EyeOfTheTiger eott=new EyeOfTheTiger();
            eott.display();
        }

        if (text.equals("Snack Shack")){
            SnackShack ss=new SnackShack();
            ss.display();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
