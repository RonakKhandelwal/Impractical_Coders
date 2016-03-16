package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by ronak on 9/10/15.
 */
public class ReadReviews {

    public void start(){
        Stage window = new Stage();
        TextArea textArea[]=new TextArea[100];
        VBox vBox=new VBox();
        int i=0;
        for ( i=0;i<100;i++){
            textArea[i]=new TextArea();
        }
        i=0;

        Button b1=new Button();
        b1.setText("Write a review");
        b1.setOnAction(e -> {
            Reviews rev = new Reviews();
            rev.start();
            window.close();
        });


        Label l=new Label("Reviews");
        vBox.getChildren().addAll(l);
        vBox.setMargin(l, new Insets(4, 4, 4, 4));

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(b1);
        Scene scene = new Scene(vBox,400,500);
        window.setScene(scene);
        scene.getStylesheets().addAll("sample/ReadReview.css");


        try {
            File f = new File("CoffeeReviews.txt");
            FileReader fr = new FileReader(f.getAbsoluteFile());
            BufferedReader br=new BufferedReader(fr);
            String st=br.readLine();
            while (st != null){
                if (st.indexOf("lines") != -1){
                    i++;
                    textArea[i].setEditable(false);
                    textArea[i].setPrefSize(400,100);
                    st=br.readLine();
                    //textArea[i].appendText(st);
                    vBox.getChildren().addAll(textArea[i]);
                }
                textArea[i].appendText("\n"+st);
                st=br.readLine();
            }
            window.show();

        }
        catch (Exception f){
            System.out.print("File Not Found");
            int ans=JOptionPane.showConfirmDialog(null,"No reviews present, would you like to add one?","Review?",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ans == JOptionPane.YES_OPTION){
                window.close();
                Reviews rev=new Reviews();
                rev.start();

            }
            f.printStackTrace();
        }





    }
}
