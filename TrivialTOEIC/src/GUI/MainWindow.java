/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import Model.Main;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author quentinlaporte-chabasse
 */

public class MainWindow extends JFrame{
    private final Game currentGame;
    private final PlayersView pv;
    private final BoardView bv;
    private final JLabel mainTitle;

    public MainWindow(Game currentGame) {
        
        this.currentGame = currentGame;
        this.setTitle("TrivialTOEIC");  
        //this.setPreferredSize(new Dimension(800,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.mainTitle=new JLabel("Trivial TOEIC !!");
        this.add(this.mainTitle, BorderLayout.NORTH);
        
        this.bv=new BoardView(this.currentGame);
        this.add(this.bv,BorderLayout.CENTER);
        
        this.pv = new PlayersView(this.currentGame,this.bv);
        this.add(this.pv, BorderLayout.WEST);
        
        this.currentGame.addObserver(bv);
        QuestionView jd  = new QuestionView(currentGame, "incomplete-sentences");
        jd.setVisible(true);
        
        

        
        this.pack();
        this.setVisible(true);
    }
  
    
    
   
}
