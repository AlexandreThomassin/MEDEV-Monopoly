/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.monopoly;

/**
 *
 * @author USER
 */
public class Chance extends Autre {
    public Chance (int id) {
        super(id);
     }
    public void tirercartechance(Joueur joueur){
        if(joueur.getPosition() == getId()){
            System.out.println("Tirez une carte chance");
        }
    }
    
    
}
