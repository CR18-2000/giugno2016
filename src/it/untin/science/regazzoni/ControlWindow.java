/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class ControlWindow{
    Button dx;
    Button sx;
    Button up;
    Button down;
    Button random;
    Button start;
    Button stop;
    Scene scene2;
    Stage stage2;
    Griglia land;
    
    ControlWindow(Griglia griglia) {
        land=griglia;
        dx = new Button ("destra");
        EventHandler<ActionEvent> eventHandlerDx = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                land.moveRight();
            }
        };
        dx.addEventHandler(ActionEvent.ACTION, eventHandlerDx);
        sx = new Button ("sinistra");
        up = new Button ("su");
        down = new Button ("giu");
        random = new Button ("random");
        start = new Button ("start");
        stop = new Button ("stop");
        VBox vb = new VBox();
        vb.getChildren().addAll(dx, sx, up, down, random, start, stop);
        scene2 = new Scene (vb, 400, 400);
        stage2 = new Stage();
        stage2.setTitle("Gioca!");
        stage2.setScene(scene2);
        stage2.show();
    }
}
