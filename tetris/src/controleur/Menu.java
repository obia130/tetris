/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import Vue.APropos;
import Vue.Aide;
import Vue.Avertissement;
import Vue.Board;
import Vue.Vue;
import modele.modele;

/**
 *
 * @author kaly
 */
public class Menu implements ActionListener{
      
/********************** Variables **********************/   
    protected modele modele;
    protected Vue vue;
    protected Boutons bouton;
    protected boolean b;
    private Board board;
/*******************************************************/

/********************** Fonctions **********************/
//la fonction constructure
    public Menu(Vue vue, Boutons bouton,modele modele,Board board) {
        this.modele = modele;
        this.vue = vue;
        this.bouton = bouton;
        this.board=board;
        //On ajoute des ActionListener sur les items du menu
        this.vue.getNouvelle().addActionListener(this);
        this.vue.getQuitter().addActionListener(this);
        this.vue.getAide().addActionListener(this);
        this.vue.getApropos().addActionListener(this);
        
    }
    
/*******************************************************/
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Pour chaque evenement on effectue une action précise
        if(arg0.getSource() == vue.getQuitter())
        {
            Avertissement av = new Avertissement();
            av.maine();
        }
        else if(arg0.getSource() == vue.getAide())
        {
            Aide aide = new Aide();
            aide.maine();
        }
        else if(arg0.getSource() == vue.getApropos())
        {
            APropos apropo = new APropos();
            apropo.maine();
        }

        else if(arg0.getSource()== vue.b1)
        {
            bouton.B1();
        }
        else if(arg0.getSource()== vue.getNouvelle())
        {
            vue.board.clearBoard();
            vue.board.start();
        }
    }
/*******************************************************/
}
