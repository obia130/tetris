/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import jeutetris.JeuTetris;
import modele.modele;
//import modele.Modele;

/**
 *
 * @author moon
 */
public class Vue extends Observable implements Observer{
    /************* Création des différents éléments de l'interface *************/  
        private JFrame vue = new JFrame();
	private JMenuBar bar = new JMenuBar();
	private JMenu menu1 = new JMenu("Jeu");
        private JMenu menu4 = new JMenu("?");
        private JMenuItem Nouvelle = new JMenuItem("Nouvelle");
        private JMenuItem quitter = new JMenuItem("Quitter ");
	private JMenuItem aide = new JMenuItem("Aide ...");
	private JMenuItem apropos = new JMenuItem("A propos ...");
        private JPanel pan1 = new JPanel();
	public Board board=new Board(); 
	
	private JPanel pan2 = new JPanel();
        private JPanel pan4 = new JPanel();
        
	public JButton b1 = new JButton("Pause");;
        private JButton b2 = new JButton("Nouvelle partie");

        private JButton b6 = new JButton("Quitter");
        
        JLabel statusbar;
        
/***************************************************************************/

/******************** Déclaration de variables globales ********************/ 
	//private int taille;
        private modele modele;
    private JeuTetris parent;
        //public JPanel tab_cellule[][];
/***************************************************************************/
	
	public Vue(modele modele,Board board){                
		
		  
                
                this.board=board;
                this.modele=modele; //Initialisation du modele
                this.modele.addObserver(this); //On ajoute un observeur
                vue.setTitle("Jeu Tetris"); //On donne un titre a la fentre
                //On donne une taille a la fenetre
                vue.setMinimumSize((new Dimension(500, 500)));
		vue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //On regle les parametres de fermeture par defaut de la fenetre
	        vue.setLocationRelativeTo(null); //On centre la fenetre
		init(board);  //Initialisation des éléments de l'interface
	}
	
        
	public void init(Board board)
	{
                //On initialise les différents élements de la fenetre :
		//Ajout des différents menus au menu principal
	        vue.setJMenuBar(bar);
                menu1.add(Nouvelle);
                menu1.add(quitter);
                menu4.add(aide);
		menu4.add(apropos);
		bar.add(menu1);
                bar.add(menu4);
                //Fin d'ajout du menu à la fenêtre principal
                //Règlage de la taille des boutons
                b1.setMaximumSize(new Dimension(150, 30));             
                b2.setMaximumSize(new Dimension(150, 30));
                b6.setMaximumSize(new Dimension(150, 30));
		//Mise en forme des différents panels
                pan1.setLayout(new BorderLayout());
		pan2.setLayout(new BoxLayout(pan2, 1));
                pan2.setBorder(BorderFactory.createEtchedBorder());
                board.setBorder(BorderFactory.createEtchedBorder());
                board.setMaximumSize(new Dimension(50, 500));
                //Fin de mise en forme
                //Ajout et mise en position
                pan1.add(board, BorderLayout.CENTER);
		pan1.add(pan2, BorderLayout.EAST); 
                pan1.add(pan4, BorderLayout.SOUTH);
                pan4.add(b6);
                //Ajout des boutons et mise en forme
                pan2.add(new Box.Filler(new Dimension(15, 10), new Dimension(0, 10), new Dimension(0, 10)));
                pan2.add(b1);
		pan2.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                pan2.add(b2);

                vue.add(pan1);	
                vue.setVisible(true);
               
	}
	
        
       
    //On recupere les éléments de la vue pour pouvoir les manipuler depuis le contrôleur
    public JMenuItem getNouvelle()
    {
        return Nouvelle; //pour une nouvelle partie
    }
    public JMenuItem getQuitter() 
    {
        return quitter;
    }
       public JMenuItem getAide() //une page d'aide qui explique le jeu
    {
        return aide;
    }
        public JMenuItem getApropos() 
    {
        return apropos;
    }
    public JButton B1() 
    {
        return b1; // le bouton b1 pour la pause
    }
    public JButton B2()
    {
        return b2; // b2 pour une nouvelle partie
    }

    public JButton B6() 
    {
        return b6; // b6 pour quitter
    }
    
  
   
   //Crée une cellule
  
   
   //Fonction servant à la mise a jour
  
   /*
   
    @Override
    public void update(Observable o, Object o1) {
        boolean tab[][] = modele.plateau.getEtatCellules();
        for(int i=0; i<taille; i++)
        {
            for(int j=0; j<taille ; j++)
            {
              if(tab[i][j]==true)
              {
                  vie(i,j);
              }
              else
              {
                  mort(i,j);
              }    
            }
        }
    }	*/

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
