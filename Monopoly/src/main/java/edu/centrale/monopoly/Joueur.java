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
        this.nom = "Steve";
        this.argent = 100000;
        this.position = 0;
        this.prison = false;
        this.plateau = plateau;
    }
    
    public Joueur() {
        this.nom = "ND";
        this.argent = -1;
    }
    
    public Joueur(Joueur joueur) {
        this.nom = joueur.nom;
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
    
    
    // Méthodes 
    
    public int nbGares() {
        int res = 0;
        
        for (Case c : plateau.getCases()) {
            if (c instanceof Achetable) {
                Achetable ca = (Achetable) c;
                if (ca.getProprietaire().equals(this) && ca instanceof Gare){
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