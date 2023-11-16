package edu.centrale.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
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
                Gare ca = (Gare) cases.get(i);
                if(ca.getProprietaire().equals(joueur)){
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
