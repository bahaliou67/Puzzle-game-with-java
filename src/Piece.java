package src;

public class Piece {
        public int valeur;
        public int x;
        public int y;

        public Piece(int valeur, int x, int y){
          this.valeur=valeur;
          this.x=x;
          this.y=y;
        }

        public String toString(){
          return "" + this.valeur;
        }

        public int getX(){
          return this.x;
        }
        public int getY(){
          return this.y;
        }
        public void setX(int x){
          this.x=x;
        }
        public void setY(int y ){
          this.y=y;
        }








}
