/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class PlayersView extends JPanel{
    private Game currentGame;
    private JButton addPlayer =  new JButton("Add ");
    private JButton delPlayer = new JButton("Del ");
    private JButton begin = new JButton("Let's begin the game");
    private JTextField nameField = new JTextField(8);
    private DefaultListModel<Player> listModel = new DefaultListModel<>();
    private JList<Player> pList = new JList<>(listModel);
    private JPanel bot = new JPanel();
    
    public PlayersView(Game currentGame) {
        
        this.currentGame = currentGame;
        this.setLayout(new BorderLayout());
        this.add(pList, BorderLayout.CENTER);
        this.bot.setLayout(new BorderLayout());
        
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
                }
            }
        });
        
        this.begin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(listModel.getSize() >= 2){
                    addPlayer.setEnabled(false);
                    delPlayer.setEnabled(false);
                }
                
            }
        });
        this.add(begin, BorderLayout.NORTH);
        this.bot.add(addPlayer, BorderLayout.WEST);
        this.bot.add(nameField, BorderLayout.CENTER);
        this.bot.add(delPlayer, BorderLayout.EAST);
        this.add(pList, BorderLayout.CENTER);
        this.add(bot, BorderLayout.SOUTH);
        
    }    
}
