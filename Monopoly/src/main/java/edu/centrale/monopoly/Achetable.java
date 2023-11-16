/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.monopoly;

/**
 *
 * @author mattb
 */
public abstract class Achetable extends Case {
    
    private String nom;
    
    private int loyer;
    
    private int prix;
    
    private Joueur proprietaire;

    public Achetable(String nom, int loyer, int prix) {
        this.nom = nom;
        this.loyer = loyer;
        this.prix = prix;
        Joueur p = new Joueur();
        this.proprietaire = p;
    }
    
    public Achetable(Achetable a) {
        this.nom = a.nom;
        this.loyer = a.loyer;
        this.prix = a.prix;
        this.proprietaire = new Joueur(a.proprietaire);
    }
    
    public Achetable() {
        this.nom = "Undefined";
        this.loyer = 1;
        this.prix = 1;
        Joueur p = new Joueur();
        this.proprietaire = p;
        }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    
    //Methode servant à acheter un case par un joueur
    public void acheter(Joueur p){
        
    }

    @Override
    public String toString() {
        if(this.getProprietaire().getNom() == "Banque"){
            return nom + " (coût : " + prix + " €) - propriétaire : Aucun"; 
        }
        else {
            return nom + " (coût : " + prix + " €) - propriétaire : " + proprietaire.getNom();
        }
    }
    
    
    
}
