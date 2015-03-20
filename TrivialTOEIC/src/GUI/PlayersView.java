/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Game;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class PlayersView extends JPanel{
    
    //Model
    private Game currentGame;
    //Buttons
    
    private JButton begin = new JButton("Let's begin the game");
    
    //Add player and plyers list management
    private PlayerListPanel pListPanel;
    
    //Manage the dice 
    private JPanel top = new JPanel();
    private DicePanel dicePanel;
    
    public PlayersView(Game currentGame, BoardView bv) {
        
        //links the Model
        this.currentGame = currentGame;
        
        this.pListPanel = new PlayerListPanel(currentGame);
        //dice panel
        this.dicePanel = new DicePanel(currentGame);
        //Top panel which contains dice panel and start button
        this.top.setLayout(new BorderLayout());
        this.top.add(begin, BorderLayout.NORTH);
        this.top.add(dicePanel, BorderLayout.CENTER);
        
        this.begin.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               if(currentGame.getNumberofPlayers() >= 1){
                   pListPanel.playerButtonsEnable(false);
                   bv.paintPlayers(); 
                   dicePanel.enableRollDice();
                   begin.setEnabled(false);
               }

           }
       
       });
        
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(pListPanel, BorderLayout.CENTER);
        
    }
    
    
}
