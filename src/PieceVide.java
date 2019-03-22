package src;

public class PieceVide extends Piece{

  public char vide='v';
  public PieceVide(int valeur, int x, int y){
  super(valeur, x, y);
}

 public String toString(){
   return " ";
 }

}
