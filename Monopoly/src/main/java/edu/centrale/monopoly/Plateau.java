package edu.centrale.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public abstract class Plateau {
    private LinkedList<Joueur> joueurs;
    private ArrayList<Case> cases;

    public void initPlateau(){

    }
    /* Methode pour avancer
     * @param c case de entree
     * @param d le nombre de cases a avancer
     */
    public Case avance(Case c,int d){
        // Pas de tour
        if(this.cases.indexOf(c)+d<this.cases.size()){
            return this.cases.get(this.cases.indexOf(c)+d);
        }
        else{
            //Si ça fait un tour
            int i = this.cases.size() - this.cases.indexOf(c)-1;
            return this.cases.get(d-i);
        }


    public void tourDeJeu(){
        Random rand = new Random();
        int d1 = rand.nextInt(6) + 1;
        int d2 = rand.nextInt(6) + 1;
        int casesDeplace = d1 + d2;
        for (int i = 0; i < joueurs.size(); i++) {
            d1 = rand.nextInt(6) + 1;
            System.out.println("d1 valeur: "+d1);
            d2 = rand.nextInt(6) + 1;
            System.out.println("d2 valeur: "+d2);
            casesDeplace = d1 + d2;
            Case nouveauCase = avance(Case.get((joueurs.get(i).getPosition())),casesDeplace);
            cases.add(nouveauCase);
            if(nouveauCase instanceof Achetable){
                if(nouveauCase.proprietaire != null){
                    nouveauCase.acheter();
                }
            }
        }
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
