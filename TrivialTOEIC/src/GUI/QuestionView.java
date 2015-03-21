/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Game;
import Model.Question;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class QuestionView{
    
    private Game currentGame;
    private String category;
    private Question question;
    private ImageIcon tickIcon;
    private ImageIcon crossIcon;
    private ImageIcon questionIcon;
    
    
    public QuestionView (Game currentGame, String category){
        this.currentGame = currentGame;
        this.category = category;
        this.question = this.currentGame.randomQuestion(this.category);
        this.tickIcon = new ImageIcon("ressources/tick.png");
        this.crossIcon = new ImageIcon("ressources/cross.png");
        this.questionIcon = new ImageIcon("ressources/question.png");
    }
    
    public void askQuestion(){
    	
        String q = this.question.getQuestion();
        String content = this.question.getContent();
        JPanel mainPan = new JPanel();
        JTextArea qLabel = new JTextArea();
        
        qLabel.setLineWrap(true);
        qLabel.setWrapStyleWord(true);
        qLabel.setPreferredSize(new Dimension(300,100));
        qLabel.setEditable(false);
        
       if(content.equals("")){
           
           qLabel.setText(q);
           mainPan.add(new JScrollPane(qLabel));
    
       }else{
           
           qLabel.setText(q);
           JScrollPane vertical = new JScrollPane();
           JTextArea contentLabel = new JTextArea();
           
           contentLabel.setWrapStyleWord(true);
           contentLabel.setLineWrap(true);
           contentLabel.setEditable(false);
           contentLabel.setText(content);
           mainPan.setLayout(new GridLayout(2,1));
           mainPan.add(new JScrollPane(qLabel));
           mainPan.add(new JScrollPane(contentLabel));
       }
       String[] answers = new String[4];
       
       for(int i=0; i<4; i++){
           answers[i] = this.question.getAnswer(i);
       }
       String answer = (String)JOptionPane.showInputDialog(null,mainPan, "Question",JOptionPane.QUESTION_MESSAGE, questionIcon, answers, answers[0]);
       
       String header;
       String message;
       ImageIcon icon;
       if(answer != null && answer.equals(this.question.getRightAnswer())){
    	   header = "Right answer !";
    	   message = "Well done, it's the right answer";
    	   icon = this.tickIcon;
    	   this.currentGame.incScore(this.currentGame.getCurrentPlayer(), this.category);
       }else{
    	  header = "Wrong answer !";
    	  message = "Sorry, the right answer is : "+this.question.getRightAnswer();
    	  icon = this.crossIcon;
       }
     
       JOptionPane.showMessageDialog(null, message, header, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
