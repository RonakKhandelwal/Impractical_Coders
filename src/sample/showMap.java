package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
//import com.lynden.gmapsfx.javascript.object.MapType;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;


public class showMap  implements MapComponentInitializedListener{

    GoogleMapView mapView;
    GoogleMap map;
    double coffeeLat=13.350513;
    double coffeelong=74.786956;

    double cur_lat=13.35139;
    double cur_long=74.792574;
    Hyperlink reach=new Hyperlink("Want to reach there??");



    public void start(Double a,Double b) throws Exception {

        //Create the JavaFX component and set this as a listener so we know when
        //the map has been initialized, at which point we can then begin manipulating it.
        coffeeLat=a;
        coffeelong=b;
        Stage stage=new Stage();
        mapView = new GoogleMapView();
        //File f=new File("auto1.jpg");
        ImageView iv=new ImageView(new Image(getClass().getResourceAsStream("auto1.jpg")));
        mapView.addMapInializedListener(this);
        /*GridPane gp=new GridPane();
        GridPane.setConstraints(reach,2,0);*/
        VBox vb=new VBox();
        Button b2=new Button("Arrange Transport",iv);
        Tooltip tp=new Tooltip("Nearest Auto Stand: BigBoss\nContact Number:08202574200");
        b2.setTooltip(tp);
        Label open=new Label("Time:11:00am-11:30pm");
        HBox hb=new HBox();
        hb.getChildren().addAll(b2,open);
        hb.setMargin(open,new Insets(4,4,4,100));

        b2.setContentDisplay(ContentDisplay.TOP);
        b2.setOnAction(e ->{
            int ans=JOptionPane.showConfirmDialog(null,"Do you want to arrange transportation?","Transportaion",JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION){
                int no=(int)5614;
                JOptionPane.showMessageDialog(null,"Pickup Point:Mit Main Gate\nAuto number "+no+"\nEstimated fare:50rs");
            }
        });
        vb.getChildren().addAll(mapView,hb);



        Scene scene = new Scene(vb);




        stage.setTitle("JavaFX and Google Maps");
        stage.setScene(scene);
        //mapView.getChildren().add(reach);
        scene.getStylesheets().addAll("sample/showMap.css");


        stage.show();
    }


    @Override
    public void mapInitialized() {
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

       


        mapOptions.center(new LatLong(coffeeLat, coffeelong))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = mapView.createMap(mapOptions);

        //Add a marker to the map
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position( new LatLong(coffeeLat, coffeelong) )
                .visible(Boolean.TRUE)
                .title("My Marker");
        MarkerOptions mo1= new MarkerOptions();
        mo1.position(new LatLong(cur_lat,cur_long))
                .visible(Boolean.TRUE)
                .title("Current Position");

        Marker marker = new Marker( markerOptions );
        Marker m1=new Marker(mo1);

        map.addMarker(marker);
        map.addMarker(m1);

    }

    public static void main(String[] args) {
        launch(args);
    }
}