package src;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.*;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Graphique extends JFrame implements Observer{

  public static int nb_graphique = 0;
  public static ModelPuzzle puzzle;
  public int graphique_num;
  public ArrayList<JButton> liste_bouton = new ArrayList();


  public Graphique(ModelPuzzle puzzle){
    super(""+nb_graphique);
    this.puzzle= puzzle;
    puzzle.addObserver(this);
    nb_graphique++;
    graphique_num = nb_graphique;
    this.addKeyListener(new Clavier());
    this.setFocusable(true);

    //On définit le layout à utiliser sur le content pane
    this.getContentPane().setLayout(new GridLayout(this.puzzle.grille.size(), this.puzzle.grille.size()));
    decoupeImage();
    this.setSize(300, 300);
    this.setResizable(false);
    this.setVisible(true);

  }



  public void decoupeImage(){
    /**
      * Cette methode decoupe une image en fonction de la taille du puzzle
    */
    int cpt=0;
    for (int i = 0; i<puzzle.grille.size(); i++){
    				for(int j=0; j<puzzle.grille.size(); j++){
    					BufferedImage image;
    					try {
    						image = ImageIO.read(new File("index.jpeg"));
    						BufferedImage img = image.getSubimage((image.getWidth()/puzzle.grille.size())*j,(image.getHeight()/puzzle.grille.size())*i,(image.getWidth()/puzzle.grille.size()),(image.getHeight()/puzzle.grille.size()));
    	                    ImageIO.write(img, "jpeg", new File(cpt+".jpeg"));
                          cpt++;
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
            }
          }

  }



  public void dessin(){
        JPanel paneau = new JPanel();
        paneau.setLayout(new GridLayout(this.puzzle.grille.size(),this.puzzle.grille.size()));
        JButton bouton;
        int cpt_image=0;


        for (ArrayList<Piece> liste_piece: this.puzzle.grille) {
            for (Piece p: liste_piece) {
              if ( p.valeur == (this.puzzle.grille.size() * this.puzzle.grille.size())-1) {
                /* c'est la piece vide */
                      bouton =new JButton("");
                      bouton.setBackground(Color.WHITE);
                      bouton.setFocusable(false);
                      paneau.add(bouton);
                      this.liste_bouton.add(bouton);
                      paneau.add(bouton);
                      bouton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){


                        }
                      });
              }
              else {

                try {
                                        BufferedImage image=ImageIO.read(new File((p.valeur)+".jpeg"));
                                        bouton = new JButton(new ImageIcon((new ImageIcon( image)).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));// Taille 100 100
                                        bouton.setFocusable(false);
                                        bouton.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e){
                                          if(puzzle.estGagnante()){
                                            new JOptionPane().showMessageDialog(null,"Partie Gagnee !!!","Bravo ",JOptionPane.INFORMATION_MESSAGE);
                                            System.exit(0);
                                          }else{
                                            if (p.x==puzzle.xVide && p.y+1==puzzle.yVide)
                                             puzzle.deplacement('d');
                                             else if (p.x==puzzle.xVide && p.y-1==puzzle.yVide)
                                             puzzle.deplacement('g');
                                           else   if (p.x==puzzle.xVide-1 && p.y==puzzle.yVide)
                                             puzzle.deplacement('b');
                                           else   if(p.x== puzzle.xVide+1 && p.y==puzzle.yVide)
                                             puzzle.deplacement('h');
                                          }
                                }
                                        });
                                        paneau.add(bouton);
                                        this.liste_bouton.add(bouton);

                                        }
                                        catch (IOException e) {}

                                                }


              }
            }

        this.setContentPane(paneau);
        revalidate();
        this.repaint();


  }



  public void renitialiser(){
          this.remove(getContentPane());
          this.liste_bouton.clear();
  }


  public void update(Observable o, Object arg){
        dessin();
  }


}
