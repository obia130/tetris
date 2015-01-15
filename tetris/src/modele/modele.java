/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import Vue.Board;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moon
 */
public class modele extends Observable implements Runnable{
//Le Tetrominoes énumération tient les sept formes de tetris.
 //De plus la forme vide appelé ici NoShape.
   public Thread threadM;
   public Board board;
   
   /*******************************************************/	
	private synchronized void maine() throws InterruptedException{
		notifyObservers();  //On envoie un signal au Observer
                board.repaint();
                setChanged(); //On applique les changements
                wait(5000);  //On patiente 5 s
	}
/*******************************************************/
    @Override
    public void run() {
    		while(true)
                {
                    try 
                    {
                        maine();
                    }
                    catch (InterruptedException ex) 
                    {
                        Logger.getLogger(modele.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
}
    
    
    
   public enum Tetrominoes { NoShape, ZShape, SShape, LineShape, 
               TShape, SquareShape, LShape, MirroredLShape };

    private modele.Tetrominoes pieceShape;
    private int coords[][];
    private int[][][] coordsTable;


    public modele() {

        //C'est le constructeur de la classe de la forme.
        //Le tableau coords détient les coordonnées réelles d'une pièce de Tetris.
        coords = new int[4][2];
        setShape(modele.Tetrominoes.NoShape);

    }

    public void setShape(modele.Tetrominoes shape) {
        //Le tableau coordsTable détient toutes les valeurs possibles de 
        //coordonner nos pièces de Tetris. Il s'agit d'un modèle à partir duquel 
        //toutes les pièces prennent leurs valeurs coordiate.

         coordsTable = new int[][][] {
            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }
        pieceShape = shape;

    }

    private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public modele.Tetrominoes getShape()  { return pieceShape; }
    
    
// ce code pour choisir une piece aleatoirement 
    public void setRandomShape()
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        modele.Tetrominoes[] values = modele.Tetrominoes.values(); 
        setShape(values[x]);
    }

    public int minX()
    {
      int m = coords[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coords[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][1]);
      }
      return m;
    }
//Ce code fait tourner la pièce vers la gauche. La place n'a pas à être tourné. 
//C'est pourquoi nous retournons simplement la référence à l'objet courant. 
//En regardant l'image précédente aidera à comprendre la rotation.
    
    public modele rotateLeft() 
    {
        if (pieceShape == modele.Tetrominoes.SquareShape)
            return this;

        modele result = new modele();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

  // Ce code fait tourner la pièce vers la droite. La place n'a pas à être tourné. 
  //C'est pourquoi nous retournons simplement la référence à l'objet courant. 
  //En regardant l'image précédente aidera à comprendre la rotation.
    
    public modele rotateRight()
    {
        if (pieceShape == modele.Tetrominoes.SquareShape)
            return this;

        modele result = new modele();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}
