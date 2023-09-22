/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.untin.science.regazzoni;

import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Circle;

/**
 *
 * @author crist
 */
public class Auto extends Circle{
    int nRiga;
    int nCol;
        
    Auto(int r, int c) {
        setRadius (45);
        setFill(RED);
        nRiga=r;
        nCol=c;
    }
}
