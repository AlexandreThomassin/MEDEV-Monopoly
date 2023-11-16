package edu.centrale.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public abstract class Plateau {
    private LinkedList<Joueur> joueurs;
    private ArrayList<Case> cases;

    public void initPlateau(){

    }
    /* Methode pour avancer
     * @param c case de entree
     * @param d le nombre de cases a avancer
     */
    public Case avance(Case c,int d) {
        // Pas de tour
        if (this.cases.indexOf(c) + d < this.cases.size()) {
            return this.cases.get(this.cases.indexOf(c) + d);
        } else {
            //Si ça fait un tour
            int i = this.cases.size() - this.cases.indexOf(c) - 1;
            return this.cases.get(d - i);
        }
     }
        public static int lanceLeDe() {
            return ((int) Math.floor(Math.random()*6))+1;
        }

    public void tourDeJeu(){
        int casesDeplace = lanceLeDe();
        for (int i = 0; i < joueurs.size(); i++) {
            casesDeplace = lanceLeDe();
            System.out.println("D valeur: "+lanceLeDe());
            Case nouveauCase = avance(Case.get((joueurs.get(i).getPosition())),casesDeplace);
            joueurs.get(i).setPosition(nouveauCase.getId());
            System.out.println("Le joueur "+joueurs.get(i).getNom()+" est en "+joueurs.get(i).getPosition());
            if(nouveauCase instanceof Achetable){
                if(nouveauCase.proprietaire != null){
                    if(casesDeplace%2 != 0) { // impar peut acheter
                        System.out.println("vous voulez acheter cet espace? Y/N");
                        Scanner scan = new Scanner(System.in); // Demande si veut acheter
                        String reponseAcheter = scan.nextLine();
                        //verifie si veux acheter
                        if(reponseAcheter.equals("Y"||"y")) {
                            //verifie s'il y a d'argent
                            if(joueurs.get(i).argent >= nouveauCase.prix){
                                nouveauCase.acheter();
                            } else {
                                System.out.println("vous n'avez pas assez d'argent");
                            }
                        }
                    }
                    // sinon pas achetable (pair)
                } else{
                    // paiement au proprietaire
                    joueurs.get(i).paiement(nouveauCase.getProprietaire());
                }
            } else {
                //AUTRES espaces e ses fonctions especifique, il faut créer un instance of pour chaqu'un d'eux
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
