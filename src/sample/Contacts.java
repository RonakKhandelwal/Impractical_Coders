package sample;


import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contacts {
    public void start(){
        Stage window=new Stage();
        BorderPane pane=new BorderPane();
        ImageView iv=new ImageView(new Image(getClass().getResourceAsStream("snackQr.png")));
        window.setTitle("Contact Us");
        HBox hb=new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(iv);
        pane.setTop(hb);
        Scene scene=new Scene(pane,400,500);
        scene.getStylesheets().addAll("sample/Contact.css");
        window.setScene(scene);
        window.show();
        Label l=new Label();
        l.setText("Snack Shack\n" +
                "Cafe\n" + "Address: Eshwar Nagar,\nManipal, Karnataka 576104");
        VBox vb=new VBox();
        vb.setMargin(l,new Insets(5,5,5,5));

        vb.getChildren().addAll(l);
        pane.setCenter(vb);
        vb.setAlignment(Pos.CENTER);

    }
}
