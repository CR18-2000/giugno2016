/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class MainClass extends Application {

    Griglia griglia;
    BorderPane root;
    Text contatore;
    VBox vb;
    Button addAuto;
    static int NMAXCAR = 3;
    int addcar;
    Boolean alreadyAdd = false;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        griglia = new Griglia();
        root.setCenter(griglia);
        addAuto = new Button("Aggiungi auto");
        EventHandler<ActionEvent> eventHandler1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                griglia.canAddCar();
                updateText();
            }
        };
        if (addcar == 3) addAuto.setDisable(true);
        addAuto.addEventHandler(ActionEvent.ACTION, eventHandler1);
        Button start = new Button ("inizia");
        EventHandler<ActionEvent> eventHandler2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControlWindow cw = new ControlWindow(griglia);
            }
        };
        start.addEventHandler(ActionEvent.ACTION, eventHandler2);
        Label label = new Label(" auto disponibili");
        contatore = new Text("3");
        HBox hb = new HBox();
        hb.getChildren().addAll(contatore, label);
        vb = new VBox();
        vb.getChildren().addAll(hb, addAuto, start);
        modificare();
        root.setRight(vb);
        Scene scene = new Scene(root, 860, 800);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public void updateText() {
        addcar = griglia.nCar;
        if (alreadyAdd == true) {
            String s = Integer.toString(NMAXCAR - addcar - 1);
            contatore.setText(s);
        } else {
            String s = Integer.toString(NMAXCAR - addcar);
            contatore.setText(s);
        }

    }

    public void modificare() {
        if (addcar == 3) {
            vb.getChildren().remove(addAuto);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
