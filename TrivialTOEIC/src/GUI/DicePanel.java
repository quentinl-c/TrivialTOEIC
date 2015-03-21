/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Game;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class DicePanel extends JPanel implements Observer{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton rollDice;
    private JButton clockwiseB;
    private JButton counterclockwiseB;
    private JLabel diceValue = new JLabel("0");
    private Game currentGame;
    
    public DicePanel(Game currentGame){
    	
        //Set the Grid Layout for this Pane 
       this.setLayout(new GridLayout(2,2));
       
       this.currentGame = currentGame;
       this.currentGame.addObserver(this);
       //import icon
       
       ImageIcon diceIcon = new ImageIcon("ressources/dice.png");
    
       this.rollDice = new JButton(diceIcon);
   
       
       //Import Icon
       ImageIcon clockw = new ImageIcon("ressources/clockw.png");
       ImageIcon counterclockw = new ImageIcon("ressources/counterclockw.png");
       
       this.clockwiseB = new JButton(clockw);
       this.counterclockwiseB = new JButton(counterclockw);
       
       this.desableRollDice();
       this.desableClokwise();
       //attribute Listeners
       this.rollDice.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               diceValue.setText(Integer.toString(currentGame.rollTheDice()));
               clockwiseB.setEnabled(true);
               counterclockwiseB.setEnabled(true);
               rollDice.setEnabled(false);
           }
       });
       
       this.clockwiseB.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               //TODO
               currentGame.clockwise(Integer.parseInt(diceValue.getText()),currentGame.getCurrentPlayer());
               String category;
               if(currentGame.getCategory().equals("Base")){
            	   category = "advanced-structures"; //default value
               }else{
            	   category = currentGame.getCategory();
               }
               QuestionView qView = new QuestionView(currentGame, category);
               qView.askQuestion();
               enableRollDice();
               desableClokwise();
               
           }
       });
       
       this.counterclockwiseB.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               //TODO
               currentGame.counterClockwise(Integer.parseInt(diceValue.getText()),currentGame.getCurrentPlayer());
               String category;
               if(currentGame.getCategory().equals("Base")){
            	   category = "advanced-structures"; //default value
               }else{
            	   category = currentGame.getCategory();
               }
               QuestionView qView = new QuestionView(currentGame, category);
               qView.askQuestion();
               enableRollDice();
               desableClokwise();
           }
       });
       
       this.add(this.rollDice);
       this.add(this.diceValue);
       this.add(this.clockwiseB);
       this.add(this.counterclockwiseB);
    }
    public void enableRollDice(){
        this.rollDice.setEnabled(true);
    }
    public void desableRollDice(){
        this.rollDice.setEnabled(false);
    }
    public void enableClockwise(){
    	this.clockwiseB.setEnabled(true);
    	this.counterclockwiseB.setEnabled(true);
    }
    public void desableClokwise(){
    	this.clockwiseB.setEnabled(false);
    	this.counterclockwiseB.setEnabled(false);
    }
	@Override
	public void update(Observable o, Object arg) {
		if(this.currentGame.isGameOver()){
			this.desableClokwise();
			this.desableRollDice();
			JOptionPane.showMessageDialog(null,
				    "Well done ! "+this.currentGame.getPlayer(this.currentGame.getCurrentPlayer()).getName()+"has won :",
				    "Game over",
				    JOptionPane.WARNING_MESSAGE);
		}
		
	}
    
 
    
}
