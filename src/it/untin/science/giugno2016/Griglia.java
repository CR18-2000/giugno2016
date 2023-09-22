/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import java.util.ArrayList;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author crist
 */
public class Griglia extends GridPane {

    //GridPane griglia;
    int NCOL = 8, NROW = 8;
    boolean addCar;
    int nCar;
    boolean done;
    boolean[][] mat;
    ArrayList<Auto> cars = new ArrayList<>();

    Griglia() {
        addCar = false;
        done = false;
        nCar = 0;
        mat = new boolean[8][8];
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setPercentWidth(100. / NCOL);
        RowConstraints rc1 = new RowConstraints();
        rc1.setPercentHeight(100. / NROW);
        getColumnConstraints().addAll(cc1, cc1, cc1, cc1, cc1, cc1, cc1, cc1);
        getRowConstraints().addAll(rc1, rc1, rc1, rc1, rc1, rc1, rc1, rc1);
        Terreno x = null;
        for (int i = 0; i < NROW; i++) {
            for (int j = 0; j < NCOL; j++) {
                if (i == 0 || i == 7 || j == 0 || j == 7) {
                    x = new Strada(i, j, this);
                    mat[i][j] = x.tipologia(i, j);
                } else {
                    x = new Prato(i, j, this);
                    mat[i][j] = x.tipologia(i, j);
                }
                this.add(x, i, j);
            }
        }
    }

    public void canAddCar() {
        addCar = true;
        //return addCar;
    }

    public boolean alreadyAddCar() {
        addCar = false;
        done = false;
        return addCar;
    }

    public boolean alreadyAddForMain() {
        done = true;
        return done;
    }

    public void posAuto(Auto a) {
        cars.add(a);
    }

    public void moveRight() {
        for (Auto n : cars) {
            if (n.nCol != 7) {
                System.out.println(mat[n.nCol+1][n.nRiga]);
                if (mat[n.nCol+1][n.nRiga] == true) {
                    n.nCol++;
                    System.out.println("car moved right");
                }

            }
        }
    }
}
