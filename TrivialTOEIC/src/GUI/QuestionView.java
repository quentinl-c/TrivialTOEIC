/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import Model.Question;
import com.sun.j3d.utils.applet.MainFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class QuestionView extends JDialog{
    
    private Game currentGame;
    private JLabel content =  new JLabel();
    private JLabel question = new JLabel();
    private JLabel contentQuestion = new JLabel();
    private JPanel mainPan = new JPanel();
    private JPanel answers = new JPanel();
    private JPanel center = new JPanel();

    
    
    
    
    public QuestionView (Game currentGame){
        super();
        //Set Layouts
        this.center.setLayout(new GridLayout(2,1));
        this.answers.setLayout(new GridLayout(2,2));
        this.mainPan.setLayout(new BorderLayout());
        //link to the model
        this.currentGame = currentGame;
        Question q = this.currentGame.randomQuestion("grammar");
       
        this.question.setText(q.getQuestion());
        this.content.setText(q.getContent());
        this.center.add(this.content);
        for(int i = 0; i<4; i++){
            JButton answer = new JButton(q.getAnswer(i));
            this.answers.add(answer);
        }
        this.center.add(this.answers);
        this.mainPan.add(this.question, BorderLayout.NORTH);
        this.mainPan.add(this.center, BorderLayout.CENTER);
        
        this.add(this.mainPan);
        this.setMinimumSize(new Dimension(500, 300));
        this.setPreferredSize(new Dimension(500, 300));
        
        
    }
    
}
