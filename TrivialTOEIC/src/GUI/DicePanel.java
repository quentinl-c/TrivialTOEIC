/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class DicePanel extends JPanel{
    private JButton rollDice;
    private JButton clockwiseB = new JButton("clockwise");
    private JButton counterclockwiseB = new JButton("counterclockwise");
    private JLabel diceValue = new JLabel("0");
    private Game currentGame;
    
    public DicePanel(Game currentGame){
        //Set the Gride Layout for this Pane 
       this.setLayout(new GridLayout(2,2));
       this.currentGame = currentGame;
       
       //import icon
       ImageIcon diceIcon = new ImageIcon("ressources/dice.png");
       this.rollDice = new JButton(diceIcon);
       
       //attribute Listeners
       this.rollDice.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               diceValue.setText(Integer.toString(currentGame.rollTheDice()));
               rollDice.setEnabled(false);
           }
       });
       
       this.clockwiseB.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               //TODO
               System.out.println("Clockwise");
           }
       });
       
       this.counterclockwiseB.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               //TODO
               System.out.println("Counterclockwise");
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
}
