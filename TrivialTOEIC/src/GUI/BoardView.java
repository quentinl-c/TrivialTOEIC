/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Board;
import Model.Game;
import Model.Main;
import Model.Player;
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
    
    private Game currentGame;
    private Board board;
    private BufferedImage imageCasual; //to remove later if not used, use this one for tests
    private BufferedImage  imageCenter;
    private BufferedImage  imageCross;
    private BufferedImage  imageBase;
    private BufferedImage  imageCategory1;
    private BufferedImage  imageCategory2;
    private BufferedImage  imageCategory3;
    private BufferedImage  imageCategory4;
    private BufferedImage  yellowPawn;
    private BufferedImage  redPawn;
    private BufferedImage  bluePawn;
    private BufferedImage  greenPawn;

    BoardView(Game currentGame) {
        this.setPreferredSize(new Dimension(500,500));
        this.currentGame=currentGame;
        this.board=currentGame.getBoard();
        this.setBackground(Color.LIGHT_GRAY);
        
        try {                
          imageCasual = ImageIO.read(new File("ressources/github.png"));
          imageCategory1 = ImageIO.read(new File("ressources/Category1.png"));
          imageCategory2 = ImageIO.read(new File("ressources/Category2.png"));
          imageCategory3 = ImageIO.read(new File("ressources/Category3.png"));
          imageCategory4 = ImageIO.read(new File("ressources/Category4.png"));
          imageCenter = ImageIO.read(new File("ressources/center.png"));
          imageCross = ImageIO.read(new File("ressources/cross.png"));
          imageBase = ImageIO.read(new File("ressources/base.png"));
          yellowPawn = ImageIO.read(new File("ressources/yellowPawn.png"));
          redPawn = ImageIO.read(new File("ressources/redPawn.png"));
          bluePawn = ImageIO.read(new File("ressources/bluePawn.png"));
          greenPawn = ImageIO.read(new File("ressources/greenPawn.png"));
          
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
                    int[] tempArray={i,j};
                    int index = this.board.getIndexFromVal(tempArray);
                    String type = this.board.getCategory(index);
                    switch(type){
                        case "Category 1":
                            g.drawImage(imageCategory1, i*50+10, j*50+10, this);
                            break;
                            
                        case "Category 2":
                            g.drawImage(imageCategory2, i*50+10, j*50+10, this);
                            break;
                        
                        case "Category 3":
                            g.drawImage(imageCategory3, i*50+10, j*50+10, this);
                            break;
                            
                        case "Category 4":
                            g.drawImage(imageCategory4, i*50+10, j*50+10, this);
                            break;
                         
                        default:
                            System.out.println("Error"); 
                    }
                }
            }
        }
    }
     
    public void paintPlayers(){
        Graphics g = this.getGraphics();
        
        for(Player player : this.currentGame.getPlayers()){
            int key = player.getPos();
            int[] pos = this.board.getValfromIndex(key);
            String color = player.getColor();
            
            switch(color){
                case "yellow":
                    g.drawImage(yellowPawn, pos[0]*50+10, pos[1]*50+10, this);
                    break;
                
                case "red":
                    g.drawImage(redPawn, pos[0]*50+10, pos[1]*50+10, this);
                    break;
                
                case "blue":
                    g.drawImage(bluePawn, pos[0]*50+10, pos[1]*50+10, this);
                    break;
                    
                case "green":
                    g.drawImage(greenPawn, pos[0]*50+10, pos[1]*50+10, this);
                    break;
                
                default:
                    break;
            }
            
        }
       
    }
    
}
