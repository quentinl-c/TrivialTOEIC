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
    private String content;
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
    
    public void setContent(String content){
        this.content = content;
    }
    public String toString(){
        String result = this.question + this.content;
        for(String s : this.answers){
            result = result+" "+s;
        }
        result = result+" "+this.rightAnswer;
        return result;
    }
    public String getQuestion(){
        return this.question;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getAnswer(int index){
        if(index < this.answers.size()){
            return this.answers.get(index);
        }else{
            return "Error";
        }
        
    }
    
    public String getRightAnswer(){
        return this.rightAnswer;
    }
    
    
    public boolean answerVerif( String answer){
        return this.rightAnswer.equals(answer);
    }
    
   
   
}
