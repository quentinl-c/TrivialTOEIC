/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Game;
import Model.Player;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class PlayerListPanel extends Panel {
    
    private Game currentGame;
    private JTextField nameField = new JTextField(8);
    private DefaultListModel<Player> listModel = new DefaultListModel<>();
    private JList<Player> pList = new JList<>(listModel);
    private JButton addPlayer =  new JButton("Add ");
    private JButton delPlayer = new JButton("Del ");
    private JPanel bot = new JPanel();
    private JPanel mainPan = new JPanel();
    private GamePanel gPanel;
    
    public PlayerListPanel(Game currentGame){
    	
    	this.currentGame = currentGame;
    	
    	//Set Layouts 
        this.setLayout(new BorderLayout());
        this.mainPan.setLayout(new GridLayout(2,1));
        this.bot.setLayout(new BorderLayout());
        
        this.gPanel = new GamePanel(currentGame);
        
        this.addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String inputText = nameField.getText();
               if(!inputText.equals("")){
                   if(listModel.getSize()<4){
                       Player pl = new Player(inputText);
                       currentGame.addPlayer(pl);
                       listModel.addElement(pl);		
                       nameField.requestFocus();
                       nameField.setText("");
                       System.out.println(currentGame.getPlayers());
                       if(listModel.getSize() ==4){
                           addPlayer.setEnabled(false);
                       }
                   }
                   
                }
            }
        });
        
        this.delPlayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pList.isSelectionEmpty()){
                    int index = pList.getSelectedIndex();
                    listModel.remove(index);
                    currentGame.removePlayer(index);
                    System.out.println(currentGame.getPlayers());
                    addPlayer.setEnabled(true);
                }
                
            }
        });
        
        
        this.bot.add(addPlayer, BorderLayout.WEST);
        this.bot.add(nameField, BorderLayout.CENTER);
        this.bot.add(delPlayer, BorderLayout.EAST);
        
        this.mainPan.add(gPanel);
        this.mainPan.add(pList);
        
        this.add(mainPan, BorderLayout.CENTER);
        this.add(bot, BorderLayout.SOUTH);
    }
    
    public void playerButtonsEnable(boolean bool){
        this.addPlayer.setEnabled(bool);
        this.addPlayer.setVisible(bool);
        
        this.nameField.setEnabled(bool);
        this.nameField.setVisible(bool);
        
        this.delPlayer.setEnabled(bool);
        this.delPlayer.setVisible(bool);

    }
}
