/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.monopoly;

/**
 *
 * @author mattb
 */
public class EmplacementConstructible extends Achetable {

    //Constructions sur la case (0 = rien, 1 = une maison, 4 = un hôtel)
    
    private int niveau_constr;
    
    private int prix_constr;
        
    public EmplacementConstructible( int niveau_constr, int prix_constrString,int nom, int loyer, int prix, Joueur j, int id) {
        super(nom, loyer, prix,j, id);
        this.niveau_constr = niveau_constr;
        this.prix_constr = prix_constr;
        
    }

    public EmplacementConstructible(EmplacementConstructible a) {
        super(a);
        this.niveau_constr=a.niveau_constr;
        this.prix_constr=a.prix_constr;
        
    }

    public EmplacementConstructible() {
        Joueur j = new Joueur();
        super("Emplacement_sans_nom",1,1,0,j);
        this.prix_constr = 1;
        this.niveau_constr = 1;
    }
    
    //Methode de contruction sur la case
    public void construire(){
        
    }

    public int getNiveau_constr() {
        return niveau_constr;
    }

    public void setNiveau_constr(int niveau_constr) {
        this.niveau_constr = niveau_constr;
    }

    public int getPrix_constr() {
        return prix_constr;
    }

    public void setPrix_constr(int prix_constr) {
        this.prix_constr = prix_constr;
    }
    
        @Override
    public String toString() {
        if(this.getProprietaire().getNom() == "Banque"){
            return this.getNom() + " (coût : " + this.getPrix() + " €) - propriétaire : Aucun"; 
        }
        else {
            if(this.niveau_constr == 4){
                return this.getNom() + " (coût : " + this.getPrix() + " €) - propriétaire : " + this.getProprietaire().getNom() + " - 1 Hôtel - Loyer : " + this.getLoyer()+ "€";    
            }
            else{
                return this.getNom() + " (coût : " + this.getPrix() + " €) - propriétaire : " + this.getProprietaire().getNom() + " - " + this.getNiveau_constr()+" maison(s) - Loyer : " + this.getLoyer()+ "€";
            }
        }
    }
    
        
    public int calculLoyer(){
        if(this.getProprietaire().getNom() == "Banque"){
            this.setLoyer(0);    
        }
        else{
            int h =this.getNiveau_constr();
            this.setLoyer(1000* h+1000);
        }
    }
    
    
}
