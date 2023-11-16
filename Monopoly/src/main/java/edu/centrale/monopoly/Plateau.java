package edu.centrale.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Plateau {
    private LinkedList<Joueur> joueurs;
    private ArrayList<Case> cases;
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


    @Override
    public String toString() {
        return super.toString();
    }
}
