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
        for (int i = 0; i < this.joueurs.size(); i++) {
            casesDeplace = lanceLeDe();
            System.out.println("D valeur: "+lanceLeDe());
            Case nouveauCase = avance(this.cases.get((this.joueurs.get(i).getPosition())),casesDeplace);
            this.joueurs.get(i).setPosition(nouveauCase.getId());
            System.out.println("Le joueur "+this.joueurs.get(i).getNom()+" est en "+this.joueurs.get(i).getPosition());
            if(nouveauCase instanceof Achetable){
                if(nouveauCase.getProprietaire != null){
                    if(casesDeplace%2 != 0) { // impar peut acheter
                        System.out.println("vous voulez acheter cet espace? Y/N");
                        Scanner scan = new Scanner(System.in); // Demande si veut acheter
                        String reponseAcheter = scan.nextLine();
                        //verifie si veux acheter
                        if(reponseAcheter.equals("Y"||"y")) {
                            //verifie s'il y a d'argent
                            if(this.joueurs.get(i).getArgent() >= nouveauCase.getPrix()){
                                nouveauCase.acheter(this.joueurs.get(i));
                            } else {
                                System.out.println("vous n'avez pas assez d'argent");
                            }
                        }
                    }
                    // sinon pas achetable (pair)
                }
                else{
                    //Verifier si c'est vous le proprietaire
                    if(nouveauCase.getProprietaire() != this.joueurs.get(i)){
                        // paiement au proprietaire
                        if(this.joueurs.get(i).getArgent()<nouveauCase.getLoyer(){
                            this.joueurs.get(i).paiement(nouveauCase.getProprietaire(),this.joueurs.get(i).getArgent());
                            System.out.println("fin de jeu pour "+this.joueurs.get(i).getNom());
                            this.joueurs.remove(i);
                        } else{
                            System.out.println(nouveauCase.getLoyer()+"payé pour le proprietaire");
                            this.joueurs.get(i).paiement(nouveauCase.getProprietaire(), nouveauCase.getLoyer());
                        }
                    }
                    System.out.println("tu es chez toi");
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
