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
        
    public EmplacementConstructible(String nom, int loyer, int prix, int niveau_constr, int prix_constr) {
        super(nom, loyer, prix);
        this.niveau_constr = niveau_constr;
        this.prix_constr = prix_constr;
        
    }

    public EmplacementConstructible(EmplacementConstructible a) {
        super(a);
        this.niveau_constr=a.niveau_constr;
        this.prix_constr=a.prix_constr;
        
    }

    public EmplacementConstructible() {
        super("Emplacement_sans_nom",1,1);
        this.prix_constr = 1;
        this.niveau_constr = 1;
    }
    
    //Methode de contruction sur la case
    public void construire(){
        
    }
    
}
