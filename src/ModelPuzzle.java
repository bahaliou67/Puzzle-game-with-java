package src;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;



/**
* La classe observable pour le mvc
*/

public class ModelPuzzle extends Observable{
//plus grande Piece en valeur est considere comme vide

        public int xVide, yVide, vide;

        public ArrayList<ArrayList<Piece>> grille;

        public ModelPuzzle(int n){
          this.vide = n*n-1;
           this.grille = new ArrayList<ArrayList<Piece>>();
           int compteur = 0;
              for(int i=0; i<n; i++){
                this.grille.add(new ArrayList<Piece>());
                 for(int j=0; j<n; j++){
                   if (compteur==n*n-1){
                     this.grille.get(i).add(new PieceVide(compteur,i,j));
                     this.xVide = i;
                     this.yVide = j;
                   }
                   else
                      {
                        this.grille.get(i).add(new Piece(compteur,i,j));
                      }
                   compteur += 1;

                   }
              }
             melanger();
        }



        /**
        * Methode qui melange la grille
        */

      public void melanger(){

         Random rand = new Random();
         int n = 100;
         //int r = rand.nextInt(n);
         char[] direct = {'d','g','b','h'};
        for(int i=0;i<n*n;i++){
           this.deplacement(direct[rand.nextInt(4)]);
        }
     }




     /**
       *Representation du puzzle en forma texte
      */
        public String toString(){

          String res= "";
          for(int i=0; i<this.grille.size(); i++){
             for(int j=0; j<this.grille.get(i).size(); j++){
               res=res+" "+this.grille.get(i).get(j);
                }
                res+="\n";
          }
          return res;

      }


      /**
      Fonction de Deplacement
      **/
          public void deplacement(char direction){

            if (direction == 'd') {
              // pour deplacer une piece vers le vide de la droite vers la gauche

                if (this.yVide > 0) {
                  // on tester si il ya deplacement possible dabord
                  Piece piece_vide = this.grille.get(xVide).get(yVide-1);
                  this.grille.get(xVide).set(yVide-1,this.grille.get(xVide).get(yVide));
                  this.grille.get(xVide).set(yVide,piece_vide);

                  this.grille.get(xVide).get(yVide).setX(xVide);
                  this.grille.get(xVide).get(yVide).setY(yVide);

                  this.yVide = this.yVide -1;
                }

            }

            if (direction == 'g') {
              // pour deplacer une piece vers le vide de la gauche vers la droite
                    int yMax = this.grille.size() ; // c'est un tableau carree
                if (this.yVide < yMax-1) {
                  // on tester si il ya deplacement possible dabord
                  Piece piece_vide = this.grille.get(xVide).get(yVide+1);
                  this.grille.get(xVide).set(yVide+1,this.grille.get(xVide).get(yVide));
                  this.grille.get(xVide).set(yVide,piece_vide);
                  this.grille.get(xVide).get(yVide).setX(xVide);
                  this.grille.get(xVide).get(yVide).setY(yVide);
                  this.yVide = this.yVide +1;
                }

            }

            if (direction == 'b') {
              // pour deplacer une piece vers le vide du bas vers la haut

                if (this.xVide > 0) {
                  // on tester si il ya deplacement possible dabord
                  Piece piece_vide = this.grille.get(xVide-1).get(yVide);
                  piece_vide.setX(xVide);
                  piece_vide.setY(yVide);
                  this.grille.get(xVide-1).set(yVide,this.grille.get(xVide).get(yVide));
                  this.grille.get(xVide).set(yVide,piece_vide);
                  this.xVide = this.xVide -1;
                }

            }


            if (direction == 'h') {
              // pour deplacer une piece vers le vide du haut vers le bas
                int xMax = this.grille.size() ; // c'est un tableau carree
                if (this.xVide < xMax-1) {
                  // on tester si il ya deplacement possible dabord
                  Piece piece_vide = this.grille.get(xVide+1).get(yVide);
                  piece_vide.setX(xVide);
                  piece_vide.setY(yVide);
                  this.grille.get(xVide+1).set(yVide,this.grille.get(xVide).get(yVide));
                  this.grille.get(xVide).set(yVide,piece_vide);
                  this.xVide = this.xVide +1;
                }
          }
          setChanged();
          notifyObservers();
        }



        /**
          *Methode qui teste si un puzzle est terminé
        */
          public boolean estGagnante(){
	   int n=this.grille.size();
            for (int i=0; i<n; i++) {
              for (int j=0; j< (n-1); j++) {
                if (this.grille.get(i).get(j).valeur > this.grille.get(i).get(j+1).valeur) {
                      return false;
                }
              }
            }
            if (xVide < this.grille.size()-1 || yVide < this.grille.size()-1) {
                return false;
            }
            return true;
          }


  }
