package sample;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.sun.javafx.stage.WindowCloseRequestHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import com.sun.javafx.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class sReviews   {

    public void start(){
        Stage window = new Stage();
        window.setTitle("Write a review");
        TextField tf = new TextField();

       // Rating rating=new Rating();
        Label l= new Label("Name : ");
        window.setOnCloseRequest(e ->{
            e.consume();
            int answer=JOptionPane.showConfirmDialog(null,"Are you sure you want to leave","Exit?",JOptionPane.YES_NO_CANCEL_OPTION);
            if (answer == JOptionPane.CANCEL_OPTION || answer == JOptionPane.NO_OPTION){

            }
            else {
                window.close();
            }
        });
        TextArea review = new TextArea();
        Label re=new Label("The review");
        ChoiceBox<String> cb=new ChoiceBox<>();
        cb.getItems().addAll("1", "2", "3", "4", "5");
        Label rat=new Label("Rating:");

        Label cus=new Label("Customer recommendations!");
        TextField customer_reco=new TextField();
        HBox hb=new HBox();
        HBox hb1=new HBox();
        hb.getChildren().addAll(cb, customer_reco);
        hb1.getChildren().addAll(rat, cus);



        Button b1 = new Button();
        b1.setText("Submit");


        b1.setOnAction(e->{
            try {
                File f = new File("SnackReviews.txt");
                String rev = review.getText();
                FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);
                BufferedWriter br = new BufferedWriter(fw);
                String name=tf.getText();
                String rating=cb.getValue();
                String recom = customer_reco.getText();
                String fin = name + " : \n" + rev + "\nRating: " + rating + "\nRecommendations :" + recom;

                br.append("\nlines\n"+fin);
                br.close();
                fw.close();
                JOptionPane.showMessageDialog(null,"Thank you for the review :)");
                window.close();
            }
            catch (Exception f){
                f.printStackTrace();
            }

        });
        VBox vb=new VBox();
        vb.getChildren().addAll(l, tf, re, review,hb1,hb ,b1);
        vb.setMargin(l, new Insets(4, 4, 4, 4));
        vb.setMargin(tf, new Insets(4, 4, 4, 4));
        vb.setMargin(re, new Insets(8, 4, 4, 4));
        vb.setMargin(review, new Insets(4, 4, 4, 4));
        vb.setMargin(cb, new Insets(4, 4, 6, 4));
        vb.setMargin(rat, new Insets(6, 4, 4, 4));

        vb.setMargin(hb, new Insets(4, 4, 8, 4));
        vb.setMargin(hb1, new Insets(4, 4, 0, 4));
        hb.setMargin(cb,new Insets(4,4,4,4));
        hb.setMargin(customer_reco,new Insets(4,4,4,4));
        hb1.setMargin(rat,new Insets(4,4,4,4));
        hb1.setMargin(cus,new Insets(4,4,4,4));

        Scene scene = new Scene(vb,400,500);
        window.setScene(scene);
        window.show();
        scene.getStylesheets().addAll("sample/Reviews.css");
    }


}
