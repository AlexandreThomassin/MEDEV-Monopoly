package edu.centrale.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public abstract class Plateau {
    public LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public void setJoueurs(LinkedList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setCases(ArrayList<Case> cases) {
        this.cases = cases;
    }

    private LinkedList<Joueur> joueurs;
    private ArrayList<Case> cases;

    public void initPlateau(){
        this.cases = new ArrayList<Case>(40);
        this.joueurs = new LinkedList<Joueur>();


        cases.add(new Depart(0));
        cases.add(new EmplacementConstructible(0, 0, "MEDITERRANEAN AVENUE", 0, 60, new Joueur(), 1));
        cases.add(new Chest(2));
        cases.add(new EmplacementConstructible(0, 0, "BALTIC AVENUE", 0, 60, new Joueur(), 3));
        cases.add(new Tax(200,4));
        cases.add(new Gare("READING RAILROAD", 0, 200, new Joueur(), 5));
        cases.add(new EmplacementConstructible(0, 0, "ORIENTAL AVENUE", 0, 100, new Joueur(), 6));
        cases.add(new Chance(7));
        cases.add(new EmplacementConstructible(0, 0, "VERMONT AVENUE", 0, 100, new Joueur(), 8));
        cases.add(new EmplacementConstructible(0, 0, "CONNECTICUT AVENUE", 0, 120, new Joueur(), 9));
        cases.add(new Prison(10));
        cases.add(new EmplacementConstructible(0, 0, "ST. CHARLES PLACE", 0, 140, new Joueur(), 11));
        cases.add(new Special("ELECTRIC COMPANY", 0, 150, new Joueur(), 12));
        cases.add(new EmplacementConstructible(0, 0, "STATES AVENUE", 0, 140, new Joueur(), 13));
        cases.add(new EmplacementConstructible(0, 0, "VIRGINIA AVENUE", 0, 140, new Joueur(), 14));
        cases.add(new Gare("PENSYLVANNIA RAILROAD", 0, 200, new Joueur(), 15));
        cases.add(new EmplacementConstructible(0, 0, "ST. JAMES PLACE", 0, 160, new Joueur(), 16));
        cases.add(new Chest(17));
        cases.add(new EmplacementConstructible(0, 0, "TENNESSEE AVENUE", 0, 180, new Joueur(), 18));
        cases.add(new EmplacementConstructible(0, 0, "NEW YORK AVENUE", 0, 190, new Joueur(), 19));
        cases.add(new Parking(20));
        cases.add(new EmplacementConstructible(0, 0, "KENTUCKY AVENUE", 0, 220, new Joueur(), 21));
        cases.add(new Chance(22));
        cases.add(new EmplacementConstructible(0, 0, "INDIANA AVENUE", 0, 220, new Joueur(), 23));
        cases.add(new EmplacementConstructible(0, 0, "ILLINOIS AVENUE", 0, 240, new Joueur(), 24));
        cases.add(new Gare("B.A.O RAILROAD", 0, 200, new Joueur(), 25));
        cases.add(new EmplacementConstructible(0, 0, "ATLANTIC AVENUE", 0, 260, new Joueur(), 26));
        cases.add(new EmplacementConstructible(0, 0, "VENTINOR AVENUE", 0, 260, new Joueur(), 27));
        cases.add(new Special("WATER WORKS", 0, 150, new Joueur(), 28));
        cases.add(new EmplacementConstructible(0, 0, "MARVIN GARDENS", 0, 260, new Joueur(), 29));
        cases.add(new Prison(30));
        cases.add(new EmplacementConstructible(0, 0, "PACIFIC AVENUE", 0, 300, new Joueur(), 31));
        cases.add(new EmplacementConstructible(0, 0, "NORTH CAROLINA AVENUE", 0, 300, new Joueur(), 32));
        cases.add(new Chest(33));
        cases.add(new EmplacementConstructible(0, 0, "PENNSYLVANIA AVENUE", 0, 320, new Joueur(), 34));
        cases.add(new Gare("SHORT LINE RAILROAD", 0, 200, new Joueur(), 35));
        cases.add(new Chance(36));
        cases.add(new EmplacementConstructible(0, 0, "PARK PLACE", 0, 350, new Joueur(), 37));
        cases.add(new Tax(35,38));
        cases.add(new EmplacementConstructible(0, 0, "BOARD WALK", 0, 400, new Joueur(), 39));

        joueurs.add(new Joueur(this));
        joueurs.get(0).setNom("Joueur 1");
        joueurs.add(new Joueur(this));
        joueurs.get(1).setNom("Joueur 2");
        joueurs.add(new Joueur(this));
        joueurs.get(2).setNom("Joueur 3");
        joueurs.add(new Joueur(this));
        joueurs.get(3).setNom("Joueur 4");
        





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
        for (int i = 0; i < this.joueurs.size(); i++) {
            casesDeplace = lanceLeDe();
            System.out.println("D valeur: "+lanceLeDe());
            Case nouveauCase = avance(this.cases.get((this.joueurs.get(i).getPosition())),casesDeplace);
            this.joueurs.get(i).setPosition(nouveauCase.getId());
            System.out.println("Le joueur "+this.joueurs.get(i).getNom()+" est en "+this.joueurs.get(i).getPosition());
            if(nouveauCase instanceof Achetable){
                Achetable achetableCase = (Achetable) nouveauCase;
                if(achetableCase.getProprietaire().getNom() != "Banque"){
                    if(casesDeplace%2 != 0) { // impar peut acheter
                        System.out.println("vous voulez acheter cet espace? Y/N");
                        Scanner scan = new Scanner(System.in); // Demande si veut acheter
                        String reponseAcheter = scan.nextLine();
                        //verifie si veux acheter
                        if(reponseAcheter.equals("Y")||reponseAcheter.equals("y")) {
                            //verifie s'il y a d'argent
                            if(this.joueurs.get(i).getArgent() >= achetableCase.getPrix()){
                                //Acheter non implémenté
                                nouveauCase.acheter(this.joueurs.get(i));
                            } else {
                                System.out.println("vous n'avez pas assez d'argent");
                            }
                        }
                    }
                    // sinon pas achetable (pair)
                }
                else{

                    //C'est vous le proprietaire
                    System.out.println("tu es chez toi");
                }
            } else {
                //AUTRES espaces e ses fonctions especifique, il faut créer un instance of pour chaqu'un d'eux
            }
        }
    }
    
    public boolean findePartie(){

       for(int i=0;i<this.cases.size();i++){
            if(this.cases.get(i) instanceof Achetable){
                if(this.cases.get(i).getProprietaire()==null){
                    return false;
                }
            }
        }
        
       return true;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
