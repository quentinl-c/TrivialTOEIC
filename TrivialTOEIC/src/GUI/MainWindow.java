/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Game;

/**
 *
 * @author quentinlaporte-chabasse
 */

public class MainWindow extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Game currentGame;
    private final PlayersView pv;
    private final BoardView bv;
    private final JLabel mainTitle;

    public MainWindow(Game currentGame) {
        
        //QuestionView qView = new QuestionView(currentGame, "incomplete-sentences" );
        //qView.askQuestion();
      
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
        
       
        this.pack();
        this.setVisible(true);
    }
  
    
    
   
}
