package src;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
        ModelPuzzle p = new ModelPuzzle(3);
        Console c = new Console (p);
        Console c_ = new Console (p);

        Graphique g = new Graphique(p);
        Graphique g_ = new Graphique(p);
        

        System.out.println(c);
        System.out.println(c_);

        System.out.println("======deplacement================*******");
        p.deplacement('d');

        while (!p.estGagnante()) {
            System.out.println("======deplacement================*******");
            p.deplacement(Console.recupereDeplacement());
        }

        src.audio.Audio.playSound("../ressources/audio/partieGagnee.wav");

        System.out.println("Felicitation vous avez gagné!!!!!");




  }

}
