/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kaly
 */
public class Avertissement {
    
/************* Création des différents éléments de l'interface *************/ 
  JFrame frame = new JFrame("Quitter");
  JButton bouton1 = new JButton("Ok");
  JButton bouton2 = new JButton("Annuler");
  JLabel label1 = new JLabel("Etes vous sur de vouloir Quitter?");
  JPanel panel = new JPanel();
/***************************************************************************/    
    
  public void maine(){
  
  //Positionnement des éléments
  panel.setLayout(null);
  label1.setBounds(75,20,200,20);
  bouton1.setBounds(50,60,100,25);
  bouton2.setBounds(200,60,100,25);
  //Ajout des différents éléments 
  panel.add(label1);
  panel.add(bouton1);
  panel.add(bouton2);
  frame.add(panel);
  //Mise en forme de la fenetre principal (taille, position, ...)  
  frame.setSize(350, 150);
  frame.setResizable(false);
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  frame.setVisible(true);
  
   bouton2.addMouseListener(new MouseAdapter() {
       @Override
      public void mouseClicked(MouseEvent me) {
        frame.setVisible(false);
      }
    });
   
   bouton1.addMouseListener(new MouseAdapter() {
       @Override
      public void mouseClicked(MouseEvent me) {
       System.exit(0); 
      }
    });
 } 
}
