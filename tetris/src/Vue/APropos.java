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
public class APropos {
    
/************* Création des différents éléments de l'interface *************/  
  JFrame frame = new JFrame("A propos");
  JPanel pan1 = new JPanel();
  JPanel pan2 = new JPanel();
  JButton quit = new JButton("Quitter");
  JLabel texte = new JLabel("<html>Le jeu Tetris est l'un des jeux d'ordinateur  <br/> les plus populaires jamais créés. <br/><br/> Auteurs : S.Bahri & A.Boudeffar <br/> Version 1.0 </html>");
  JLabel espace = new JLabel("<html><br/><br/></html>"); 
  JLabel espace1 = new JLabel("<html><br/></html>"); 
  JLabel espace2 = new JLabel("<html><br/></html>"); 
  JLabel espace3 = new JLabel("<html><br/>&nbsp &nbsp &nbsp &nbsp</html>"); 
  JLabel espace4 = new JLabel("<html><br/>&nbsp &nbsp &nbsp &nbsp</html>"); 
/***************************************************************************/  
    
  public void maine(){

//Création de cadre pour la mise en forme      
  texte.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
  pan1.setBorder(BorderFactory.createTitledBorder("Jeu du Tetris"));
//Ajout des différents éléments  
  pan1.add(texte);
  pan2.add(espace);
  pan2.add(quit);
  frame.add(espace1, BorderLayout.NORTH);
  frame.add(espace3, BorderLayout.WEST);
  frame.add(pan1, BorderLayout.CENTER);
  frame.add(espace4, BorderLayout.EAST);
  frame.add(pan2, BorderLayout.SOUTH);
//Mise en forme de la fenetre principal (taille, position, ...)  
  frame.setSize(400, 340);
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
