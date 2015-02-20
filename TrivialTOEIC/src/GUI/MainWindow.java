/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author quentinlaporte-chabasse
 */

public class MainWindow extends JFrame{
    private Game currentGame;
    private PlayersView pv;
    private JLabel mainTitle = new JLabel("Trivial TOEIC !!");

    public MainWindow(Game currentGame) {
        this.currentGame = currentGame;
        this.pv = new PlayersView(this.currentGame);
        this.setTitle("TrivialTOEIC");  
        this.setPreferredSize(new Dimension(800,400));
        this.setLayout(new BorderLayout());
        this.add(this.mainTitle, BorderLayout.NORTH);
        this.add(this.pv, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
   
}
