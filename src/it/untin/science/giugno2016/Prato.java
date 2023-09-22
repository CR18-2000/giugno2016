/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import static javafx.scene.paint.Color.GREEN;

/**
 *
 * @author crist
 */
public class Prato extends Terreno {
    
    Prato(int i, int j, Griglia griglia) {
        super(i, j, griglia);
        cell.setFill(GREEN);
    }
    
    @Override
    public void clickCheck() {
        addCar = land.addCar;
       if (addCar == false) {
           land.getChildren().remove(this);
           land.add(new Strada(nRiga, nColonna, land), nRiga, nColonna);
           }
       land.addCar=land.alreadyAddCar();
    }
    
    @Override
    public void addCar() {
        
    }
    
    @Override
    boolean tipologia(int i, int j) {
        return false;
    }
}
