/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import Model.Question;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class QuestionView extends JDialog{
    
    private Game currentGame;
    private JLabel content =  new JLabel();
    private JTextArea question = new JTextArea("No Question ...");
    private JTextArea contentQuestion = new JTextArea("No content ...");
    private JPanel mainPan = new JPanel();
    private JPanel answers = new JPanel();
    private JPanel center = new JPanel();
    private JPanel questionPan = new JPanel();
    
    public QuestionView (Game currentGame, String category){
        //Set Layouts
        this.center.setLayout(new GridLayout(2,1));
        this.answers.setLayout(new GridLayout(2,2));
        this.questionPan.setLayout(new GridLayout(2,1));
        this.mainPan.setLayout(new BorderLayout());
        
        //link to the model
        this.currentGame = currentGame;
        Question q = this.currentGame.randomQuestion(category);
        
        //Init Text area
        this.question.setLineWrap(true);
        this.question.setWrapStyleWord(true);
        this.question.setEditable(false);
        
        this.contentQuestion.setLineWrap(true);
        this.contentQuestion.setWrapStyleWord(true);
        this.contentQuestion.setEditable(false);
        
        
        this.question.setText(q.getQuestion());
        this.content.setText(q.getContent());
        this.center.add(this.content);
        
        //Answers panel 
        for(int i = 0; i<4; i++){
            JButton answer = new JButton(q.getAnswer(i));
            answer.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
            this.answers.add(answer);
        }
        
        this.questionPan.add(this.question);
        this.questionPan.add(this.contentQuestion);
        this.center.add(this.answers);
        this.mainPan.add(this.question, BorderLayout.NORTH);
        this.mainPan.add(this.center, BorderLayout.CENTER);
        
        this.add(this.mainPan);
        this.setMinimumSize(new Dimension(500, 300));
        this.setPreferredSize(new Dimension(500, 300));
        
        
    }
    
}
