package sample;

import com.lynden.gmapsfx.javascript.object.LatLong;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EyeOfTheTiger implements EventHandler<ActionEvent> {
    static Stage window;
    static Scene scene;
    static Button b1,b2,b3,b4,b5;


    public  void display(){
        window = new Stage();
        Label eott=new Label();
        eott.setText("Eye Of The Tiger");
        eott.setFont(new Font("Liberation Serif",20));
        Label label=new Label("How can we help you amigo??");
        VBox layout=new VBox();
        eott.getStylesheets().addAll("sample/Name.css");
        layout.setMargin(eott,new Insets(4,4,100,4));
        layout.getChildren().add(eott);
        layout.getChildren().add(label);
        b1 = new Button("Find The Place");
        b2 = new Button("Show me the menu");
        b3 = new Button("Contact Us");
        b4 = new Button("Review");
        // b5 = new Button("Write a Review");
        b2.setOnAction(this);
        b1.setOnAction(this);
        b3.setOnAction(this);
        b4.setOnAction(this);
        //b5.setOnAction(this);

        layout.getChildren().addAll(b1, b2, b3, b4);
        layout.setMargin(b1, new Insets(4, 4, 4, 4));
        layout.setMargin(b2,new Insets(4,4,4,4));
        layout.setMargin(b3,new Insets(4,4,4,4));
        layout.setMargin(b4, new Insets(4, 4, 4, 4));
        layout.setMargin(label, new Insets(4, 4, 4, 4));
        //layout.getChildren().add(hb);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout,400,400);
        scene.getStylesheets().addAll("sample/Tiger.css");
        window.setScene(scene);
        window.show();


    }

    @Override
    public  void handle(ActionEvent event) {
        if (event.getSource() == b1){

            try{
                double a=13.351515;
                double b=74.787308;
                showMap sm = new showMap();
                sm.start(a,b);}
            catch (Exception e){
                e.printStackTrace();
            }

        }
        if (event.getSource() == b2){
            ImageView menu[]=new ImageView[3];
            menu[0]=new ImageView(new Image(getClass().getResourceAsStream("emenu1.jpg")));
            menu[1]=new ImageView(new Image(getClass().getResourceAsStream("emenu2.jpg")));
            menu[2]=new ImageView(new Image(getClass().getResourceAsStream("emenu3.jpg")));
            ShowMenu.showMenu(menu,3,250,500);


        }

        if (event.getSource() == b3){
            Contacte c=new Contacte();
            c.start();
        }

        if (event.getSource() == b4){
            eReadReviews rv = new eReadReviews();
            rv.start();
        }

        if (event.getSource() == b5){
            eReviews rv = new eReviews();
            rv.start();
        }
    }
}
