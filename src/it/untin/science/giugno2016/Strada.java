/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import static javafx.scene.paint.Color.GREY;

/**
 *
 * @author crist
 *
 */
public class Strada extends Terreno {

    //uso un booleano che mi dice se è presente la macchina
    boolean hasCar;
    Auto macchina = null;

    Strada(int i, int j, Griglia griglia) {
        super(i, j, griglia);
        //setStyle("-fx-background-color: gray;");
        cell.setFill(GREY);
        //all'inizio non ci sono macchine
        hasCar = false;
        addCar = false;
    }

    public void introdurreMacchine() {
        hasCar = true;
        macchina = new Auto(nRiga, nColonna);
        getChildren().add(macchina);
        land.posAuto(macchina);
    }

    @Override
    public void clickCheck() {
        addCar = land.addCar;
        if (hasCar == false) {
            if (addCar == false) {
                land.getChildren().remove(this);
                land.add(new Prato(nRiga, nColonna, land), nRiga, nColonna);
            } else {
                if (land.nCar < 3) {
                    introdurreMacchine();
                    land.nCar++;
                    System.out.println("introduco auto");
                } else {
                    land.getChildren().remove(this);
                    land.add(new Prato(nRiga, nColonna, land), nRiga, nColonna);

                }
            }
        }
        land.addCar = land.alreadyAddCar();
    }

    @Override
    public void addCar() {
        if (hasCar == false) {
            introdurreMacchine();
        }
    }
    
    @Override
    boolean tipologia(int i, int j) {
        return true;
    }

}
