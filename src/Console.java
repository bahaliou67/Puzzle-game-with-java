package src;

import java.util.Scanner;
import java.util.Observer;
import java.util.Observable;

public class Console implements Observer{

  public static int nb_console = 0;
  public ModelPuzzle puzzle;
  public int console_num;

  public Console(ModelPuzzle puzzle){
            this.puzzle = puzzle;
            this.puzzle.addObserver(this);
            nb_console ++;
            this.console_num = nb_console;
  }


  public void update(Observable o, Object arg){
            System.out.println(this.puzzle);
  }


  public  static char recupereDeplacement(){
    /** Methode qui recupere les caractere entre au clavier**/
    System.out.println("Saisissez une lettre entre (h:haut, g:gauche, d:droite, b:bas):");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char carac = str.charAt(0);
    System.out.println("Vous avez saisi le caractère : " + carac);
    return carac;
  }


  public String toString(){
      return "====Console===: "+console_num+"\n"+this.puzzle.toString();
  }



}
