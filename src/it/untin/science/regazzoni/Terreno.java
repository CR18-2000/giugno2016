/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author crist
 */
public abstract class Terreno extends StackPane {
    int nRiga, nColonna;
    Griglia land;
    Boolean addCar;
    Rectangle cell;
    //MainClass mainWindow = new MainClass();
    
    Terreno(int i, int j, Griglia griglia) {
        nRiga=i;
        nColonna=j;
        setStyle("-fx-background-color: black;");
        cell=new Rectangle (90, 90);
        getChildren().add(cell);
        land=griglia;
        addEventHandler (MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle (MouseEvent t) {
                clickCheck();
                Terreno source=(Terreno)t.getSource();
                System.out.println(source);
            }
        });
    }
    
    abstract void clickCheck (); 
    
    abstract void addCar();
    
    abstract boolean tipologia(int i, int j);   //ritorna true se è strada, false se è prato
}
