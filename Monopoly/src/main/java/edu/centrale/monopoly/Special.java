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
public class Special extends Achetable {

    public Special(String nom, int loyer, int prix,Joueur j, int id) {
        super(nom, loyer, prix,j, id);
    }

    public Special(Achetable a) {
        super(a);
    }

    public Special() {
        super("Special_sans_nom",1,1,new Joueur(),-1);
    }
    
        
    public void calculLoyer(Plateau p){
            this.setLoyer(400);    
    }
    
    
    
}
