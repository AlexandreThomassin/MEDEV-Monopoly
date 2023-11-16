/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.monopoly;

/**
 *
 * @author mattb
 */
public class Gare extends Achetable {

    public Gare(String nom, int loyer, int prix) {
        super(nom, loyer, prix);
    }

    public Gare(Achetable a) {
        super(a);
    }

    public Gare() {
        super("Gare_sans_nom",1,1);
    }
    
    
    
    
}
