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
    public String tirercartechance(Joueur joueur){
        if(joueur.position == id){
            System.out.println("Tirez une carte chance");
        }
    }
    
    
}
