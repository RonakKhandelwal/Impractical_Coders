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
import javafx.stage.Stage;

public class SnackShack implements EventHandler<ActionEvent> {
    static Stage window;
    static Scene scene;
    static Button b1,b2,b3,b4,b5;


    public  void display(){
        window = new Stage();
        Label label=new Label("What Do you want to do Next??");
        VBox layout=new VBox();
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
        layout.setMargin(b4,new Insets(4,4,4,4));
        layout.setMargin(label,new Insets(4,4,4,4));
        //layout.getChildren().add(hb);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout,400,400);
        scene.getStylesheets().addAll("sample/Snack.css");
        window.setScene(scene);
        window.show();


    }

    @Override
    public  void handle(ActionEvent event) {
        if (event.getSource() == b1){

            try{
                double a=13.35221;
                double b=74.787433;
                showMap sm = new showMap();
                sm.start(a,b);}
            catch (Exception e){
                e.printStackTrace();
            }

        }
        if (event.getSource() == b2){
            ImageView menu[]=new ImageView[3];
            menu[0]=new ImageView(new Image(getClass().getResourceAsStream("ssmenu1.jpg")));
            menu[1]=new ImageView(new Image(getClass().getResourceAsStream("ssmenu2.jpg")));
            menu[2]=new ImageView(new Image(getClass().getResourceAsStream("ssmenu3.jpg")));
            ShowMenu.showMenu(menu,3,768,885);


        }

        if (event.getSource() == b3){
            Contacts c=new Contacts();
            c.start();
        }

        if (event.getSource() == b4){
            sReadReviews rv = new sReadReviews();
            rv.start();
        }

        if (event.getSource() == b5){
            eReviews rv = new eReviews();
            rv.start();
        }
    }
}
