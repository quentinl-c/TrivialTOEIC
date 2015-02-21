/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Board;
import Model.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class BoardView extends JPanel{
    
    private Board board;
    private BufferedImage imageCasual;
    private BufferedImage  imageCenter;
    private BufferedImage  imageCross;
    private BufferedImage  imageBase;

    BoardView(Game currentGame) {
        this.setPreferredSize(new Dimension(500,500));
        this.board=currentGame.getBoard();
        this.setBackground(Color.LIGHT_GRAY);
        
        try {                
          imageCasual = ImageIO.read(new File("ressources/github.png"));
          imageCenter = ImageIO.read(new File("ressources/center.png"));
          imageCross = ImageIO.read(new File("ressources/cross.png"));
          imageBase = ImageIO.read(new File("ressources/base.png"));
          
       } catch (IOException ex) {
            System.out.println(ex);
       }         
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0 ; i<9 ; i++){
            for(int j = 0; j<9 ; j++){
                //center
                if(i==j&&i==4){
                    g.drawImage(imageCenter, i*50+10, j*50+10, this);
                }
                //base
                else if(i%4==0&&j%4==0&&(i+j)%8!=0){
                    g.drawImage(imageBase, i*50+10, j*50+10, this);
                }
                //cross
                else if(i==4&&j%4!=0||j==4&&i%4!=0){
                    g.drawImage(imageCross, i*50+10, j*50+10, this);
                }
                
                // casual
                else if(i%4==0||j%4==0){
                    g.drawImage(imageCasual, i*50+10, j*50+10, this);
                }
                
            }
        }
    }
    
}
