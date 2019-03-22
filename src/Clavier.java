package src;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {
  /** cette class gère les mouvement du clavier * */

   public void termine(){
    new JOptionPane().showMessageDialog(null,"Partie Gagnee !!!","Bravo ",JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);

      }


      @Override
      public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            /* si la touche en haut est appuyee */
            if(!Graphique.puzzle.estGagnante()){
              Graphique.puzzle.deplacement('d');
              src.audio.Audio.playSound("../ressources/audio/bouger.wav");
            }
            if(Graphique.puzzle.estGagnante()){
               this.termine();
             }

          }
          else if (e.getKeyCode() == KeyEvent.VK_LEFT){
              if(!Graphique.puzzle.estGagnante()){
                Graphique.puzzle.deplacement('g');
                src.audio.Audio.playSound("../ressources/audio/bouger.wav");
              }
              if(Graphique.puzzle.estGagnante()){
                 this.termine();
               }



          }
          else if (e.getKeyCode() == KeyEvent.VK_UP) {
              if(!Graphique.puzzle.estGagnante()){
                Graphique.puzzle.deplacement('h');
                src.audio.Audio.playSound("../ressources/audio/bouger.wav");
              }
              if(Graphique.puzzle.estGagnante()){
                 this.termine();
               }

          }
          else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
              if(!Graphique.puzzle.estGagnante()){
                Graphique.puzzle.deplacement('b');
               src.audio.Audio.playSound("../ressources/audio/bouger.wav");
              }
              if(Graphique.puzzle.estGagnante()){
                 this.termine();
               }
      }

      if(Graphique.puzzle.estGagnante()){
           System.out.println("Partie terminee");
           src.audio.Audio.playSound("../ressources/audio/partieGagnee.wav");
         }
    }

      @Override
      public void keyReleased(KeyEvent e) {
      }

      @Override
      public void keyTyped(KeyEvent e) {

      }

}
