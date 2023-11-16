/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.monopoly;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mattb
 */
public class Gare extends Achetable {

    public Gare(String nom, int loyer, int prix, int id) {
        super(nom, loyer, prix, id);
    }

    public Gare(Achetable a) {
        super(a);
    }

    public Gare() {
        super("Gare_sans_nom",1,1, -1);
    }
    
        
    public void calculLoyer(Plateau p){
        if(this.getProprietaire().getNom() == "Banque"){
            this.setLoyer(0);    
        }
        else{
            int h =p.nbGares(this.getProprietaire());
            this.setLoyer(2500* h);
        }
        
    }
    
    
    
}
