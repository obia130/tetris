/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeutetris;

import Vue.Board;
import Vue.Vue;
import controleur.Boutons;
import controleur.Menu;
import java.applet.Applet;
import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import static java.sql.Types.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import modele.modele;
import sun.net.www.content.audio.wav;

/**
 *
 * @author Moon
 */
public class JeuTetris {
    private static InputStream f1;

    
    
        
        
        // on commence le jeu grace a la méthode start() immédiatement apres que la fenetre soit ouverte
        
        
       
    
    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        
 
        
        Board board = new Board();
        board.start();
        modele mod=new modele ();
        Vue vue=new Vue(mod,board);
        
        Boutons bouton = new Boutons(vue,mod,board);
        Menu menu = new Menu(vue, bouton,mod,board);
        
    }


    
}
