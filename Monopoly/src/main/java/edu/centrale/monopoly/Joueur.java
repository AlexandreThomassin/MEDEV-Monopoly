/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.monopoly;

/**
 *
 * Classe Joueur 
 * 
 * @author alex4
 */
public class Joueur {
    
    // Attributs
    
    private String nom;
    
    private int argent;
    
    private int position;
    
    private boolean prison;
    
    private Plateau plateau;
    
    // Constructeurs 

    /**
     * Création d'un nouveau Joueur
     * @param plateau sur lequel le Joueur va jouer
     */
    public Joueur(Plateau plateau) {
        this.argent = 100000;
        this.position = 0;
        this.prison = false;
        this.plateau = plateau;
    }
    
    public Joueur(Joueur joueur) {
        this.argent = joueur.argent;
        this.position = joueur.position;
        this.prison = joueur.prison;
        this.plateau = joueur.plateau; 
    }
    
    // Getter Setter

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /**
     *
     * @return
     */
    public int getArgent() {
        return argent;
    }

    /**
     *
     * @param argent
     */
    public void setArgent(int argent) {
        this.argent = argent;
    }

    /**
     *
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public boolean isPrison() {
        return prison;
    }

    /**
     *
     * @param prison
     */
    public void setPrison(boolean prison) {
        this.prison = prison;
    }

    /**
     *
     * @return
     */
    public Plateau getPlateau() {
        return plateau;
    }

    /**
     *
     * @param plateau
     */
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public String toString() {
        String display =  "Joueur : " + nom + " - Fortune :" + argent + "- Case n°" + position ;
        if(this.prison){
            display += "- Est en prison";
        }
        return display;
    }
    
    
    
    // Méthodes 
    
    public int nbGares() {
        int res = 0;
        
        for (Case c : plateau.getCases()) {
            if (c instanceof Achetable) {
                if (c.proprietaire.equals(this) && c instanceof Gare){
                    res ++;
                }    
            } 
        }
        
        return res;    
    }
    
    public void paiement(Joueur j, int montant) {
        j.argent += montant;
        this.argent -= montant;
    }
}