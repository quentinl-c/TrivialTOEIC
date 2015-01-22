/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class Question {
    private String question;
    private ArrayList<String> answers;
    private String rightAnswer;
    
    public Question(String question){
        this.question = question;
        this.answers = new ArrayList<>();
    }
    
    public void setAnswer(String answer){
        this.answers.add(answer);
    }
    
    public void setRightAnswer(String rightAnswer){
        this.rightAnswer = rightAnswer;
    }
    public String toString(){
        String result = this.question;
        for(String s : this.answers){
            result = result+" "+s;
        }
        result = result+" "+this.rightAnswer;
        return result;
    }
    
   
   
}
