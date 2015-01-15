/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kaly
 */
public class Aide {
            
/************* Création des différents éléments de l'interface *************/   
  JFrame frame = new JFrame("Aide");
  JPanel pan = new JPanel();
  JButton quit = new JButton("Quitter");
  JLabel titre = new JLabel("<html><h3>Vous êtes sur le jeu du Tetris</h3></html>");
  JLabel texte = new JLabel("<html> On effectue des rotations et des translations horizontales sur des pièces qui descendent progressivement et de plus en plus rapidement.<br/><br/> Le but est de les entasser de telle sorte à essayer de former des lignes qui disparaitront si elles sont complètes ... <br/><br/>et ce, jusqu'à ce que cela aille trop vite !... \n" +
"            Il est donc possible de déplacer les pièces vers la gauche et vers la droite (via les flêches gauche et droite) ainsi que de les tourner dans le sens inverse des aiguilles d'une montre grâce à la flêche du haut. <br/><br/>La flêche du bas, quant à elle, permet d'accélérer la vitesse de descente de la pièce en cours. \n" +
"            La vitesse accélère à chaque niveau </html>");
  JLabel espace = new JLabel("<html><br/><br/><br/><br/></html>"); 
/***************************************************************************/
  
  public void maine(){

  //Création de cadre pour la mise en forme   
  titre.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
  texte.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));
  //Ajout des différents éléments    
  pan.add(espace);
  pan.add(quit);
  frame.add(titre, BorderLayout.NORTH);
  frame.add(texte, BorderLayout.CENTER);
  frame.add(pan, BorderLayout.SOUTH);
  //Mise en forme de la fenetre principal (taille, position, ...)  
  frame.setSize(600, 450);
  frame.setResizable(false);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
  
  quit.addMouseListener(new MouseAdapter() {
       @Override
      public void mouseClicked(MouseEvent me) {
        frame.setVisible(false);
      }
    });

 }
}
