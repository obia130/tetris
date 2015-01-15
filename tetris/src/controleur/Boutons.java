/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
//import modele.Modele;
import Vue.Avertissement;
import Vue.Vue;
import Vue.Board;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import modele.modele;

/**
 *
 * @author kaly
 */
public class Boutons implements ActionListener{

/********************** Variables **********************/ 
    private boolean b = false;
    private modele modele;
    private Vue vue;
    private Board board;
/*******************************************************/      
    
/********************** Fonctions **********************/
    //la fonction constructure
    public Boutons( Vue vue,modele modele,Board board) {
        this.modele = modele;
        this.board=board;
        this.vue = vue;
        this.vue.B1().addActionListener(this);
        this.vue.B2().addActionListener(this);

        this.vue.B6().addActionListener(this);
        //this.vue.board.addKeyListener(new Boutons.TAdapter());
    }
    
    public boolean getB()
    {
        return b;
    }
 /*******************************************************/   
    public synchronized void B1() 
    {
     
        //vue.board.pause();
           // modele.threadM = new Thread(modele);
         //   modele.threadM.start();           
         
         
           if(!vue.board.getIsPaused())
           {
                 vue.board.pause();
                 vue.b1.setText("Reprendre");
                 return;
           }
           if (vue.board.getIsPaused())
           {
                vue.board.pause();
        
                vue.b1.setText("Pause");   
           //     modele.threadM.stop();
                return;
           }
                 
    }
/*******************************************************/    
    public synchronized void B2()
    {
        vue.board.clearBoard();
        vue.board.start();
    }

/*******************************************************/    
    public void B6()
    {
            Avertissement av = new Avertissement();
            av.maine();
    }
/*******************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vue.B1())
        {
           
                B1();
     
            
        }
        else if(e.getSource() == vue.B2())
        {
                B2();
        }

        else if(e.getSource() == vue.B6())
        {
                B6();
        }
    }  

       
    class TAdapter extends KeyAdapter {
         @Override
         public void keyPressed(KeyEvent e) {

             if (!board.getIsStarted() ) {  
                 return;
             }

             int keycode = e.getKeyCode();

             if (keycode == 'p' || keycode == 'P') {
                 board.pause();
                 return;
             }

             if (board.getIsPaused())
                 return;

             switch (keycode) {
             case KeyEvent.VK_LEFT:
                 board.tryMove(modele, board.getCurX() - 1, board.getCurY());
                 break;
             case KeyEvent.VK_RIGHT:
                 board.tryMove(modele, board.getCurX() + 1, board.getCurY());
                 break;
             case KeyEvent.VK_DOWN:
                 board.tryMove(modele.rotateRight(),board.getCurX(), board.getCurY());
                 break;
             case KeyEvent.VK_UP:
                 board.tryMove(modele.rotateLeft(),board.getCurX(), board.getCurY());
                 break;
             case KeyEvent.VK_SPACE:
                 board.dropDown();
                 break;
             case 'd':
                 board.oneLineDown();
                 break;
             case 'D':
                 board.oneLineDown();
                 break;
             }

         }
    }
}
