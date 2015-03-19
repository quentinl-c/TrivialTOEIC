/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;
import Model.Question;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class QuestionView{
    
    private Game currentGame;
    private String category;
    private Question question;
    
    
    public QuestionView (Game currentGame, String category){
        this.currentGame = currentGame;
        this.category = category;
        this.question = this.currentGame.randomQuestion(this.category);
    }
    
    public void askQuestion(){
        System.out.println("coucou");
        String q = this.question.getQuestion();
        String content = this.question.getContent();
        JPanel mainPan = new JPanel();
        JTextArea qLabel = new JTextArea();
        
        qLabel.setLineWrap(true);
        qLabel.setPreferredSize(new Dimension(200,100));
        
       if(content.equals("")){
           
           qLabel.setText(q);
           mainPan.add(new JScrollPane(qLabel));
    
       }else{
           
           qLabel.setText(q);
           JTextArea contentLabel = new JTextArea();
           contentLabel.setPreferredSize(new Dimension(200,100));
           contentLabel.setText(content);
           mainPan.setLayout(new GridLayout(1,2));
           mainPan.add(new JScrollPane(qLabel));
           mainPan.add(new JScrollPane(contentLabel));
       }
       String[] answers = new String[4];
       
       for(int i=0; i<4; i++){
           answers[i] = this.question.getAnswer(i);
       }
       
       JOptionPane.showInputDialog(null,new JScrollPane(qLabel), "Question",JOptionPane.QUESTION_MESSAGE,null, answers, answers[0]);
    }
}
