package edu.centrale.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Plateau {
    private LinkedList<Joueur> joueurs;
    private ArrayList<Case> cases;

    public void initPlateau(){
        this.cases = new ArrayList<Case>(40);
        cases.add(new Autre(0));
        cases.add(new EmplacementConstructible(0, 0, "MEDITERRANEAN AVENUE", 0, 60, new Joueur(), 1));
        cases.add(new Chance("COMMUNITY CHEST",2));
        cases.add(new EmplacementConstructible(0, 0, "BALTIC AVENUE", 0, 60, new Joueur(), 3));
        cases.add(new Chance("INCOME TAX",4));
        cases.add(new Gare("READING RAILROAD", 0, 200, new Joueur(), 5));
        cases.add(new EmplacementConstructible(0, 0, "ORIENTAL AVENUE", 0, 100, new Joueur(), 6));
        cases.add(new Chance("CHANCE",7));
        cases.add(new EmplacementConstructible(0, 0, "VERMONT AVENUE", 0, 100, new Joueur(), 8));
        cases.add(new EmplacementConstructible(0, 0, "CONNECTICUT AVENUE", 0, 120, new Joueur(), 9));
        cases.add(new Prison(10));
        cases.add(new EmplacementConstructible(0, 0, "ST. CHARLES PLACE", 0, 140, new Joueur(), 11));
        cases.add(new EmplacementConstructible(0, 0, "ELECTRIC COMPANY", 0, 150, new Joueur(), 12));
        cases.add(new EmplacementConstructible(0, 0, "STATES AVENUE", 0, 140, new Joueur(), 13));
        cases.add(new EmplacementConstructible(0, 0, "VIRGINIA AVENUE", 0, 140, new Joueur(), 14));
        cases.add(new Gare("PENSYLVANNIA RAILROAD", 0, 200, new Joueur(), 15));
        cases.add(new EmplacementConstructible(0, 0, "ST. JAMES PLACE", 0, 160, new Joueur(), 16));
        cases.add(new Chance("COMMUNITY CHEST",17));
        cases.add(new EmplacementConstructible(0, 0, "TENNESSEE AVENUE", 0, 180, new Joueur(), 18));
        cases.add(new EmplacementConstructible(0, 0, "NEW YORK AVENUE", 0, 190, new Joueur(), 19));
        cases.add(new Autre("FREE PARKING", 20));
    }
    public int nbGares(Joueur joueur){
        int nbGares=0;
        for(int i=0;i<cases.size();i++){
            if(cases.get(i) instanceof Gare){
                if(cases.get(i).proprietaire.equals(joueur)){
                    nbGares++;
                }
            }
        }
        return nbGares;
    }
    public void affiche(){
        for(int i=0;i<cases.size();i++){
            cases.get(i).toString();
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
