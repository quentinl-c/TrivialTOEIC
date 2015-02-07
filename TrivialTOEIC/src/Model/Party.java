/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author quentinlaporte-chabasse
 * Model of application
 * Manages : players, board, questions and answers
 */
public class Party {
    
    private ArrayList<Player> players;
    private boolean gameOver; //true when a player win a party
    private HashMap<String, ArrayList<Question>> questions;
    private HashMap<String, ArrayList<Question>> questionsUsed;
    
    public Party(){
        this.players = new ArrayList<>();
        this.gameOver = false;
        this.questions = new HashMap<>();
        this.questionsUsed = new HashMap<>();
    }
    public void initParty(ImportJSON jsonImportation){
        initCategory("grammar", jsonImportation);
        initCategory("vocabulary", jsonImportation);
    }
    
    public Question randomQuestion(String category){
        if(this.questions.containsKey(category)){
            if(questions.get(category).isEmpty()){
                this.questions.put(category, (ArrayList<Question>)this.questionsUsed.get(category).clone());
            }
            int maxBound = questions.get(category).size() ;
            Random rand = new Random();
            int randomNum = rand.nextInt(maxBound);
            Question q = this.questions.get(category).remove(randomNum);
            this.questionsUsed.get(category).add(q);
            return q;

        
        }else{
            return null;
        }   
    }
    
    public void addPlayer(String name){
        int id = this.players.size();
        Player currentPlayer = new Player(id, name);
        this.players.add(currentPlayer);
    }
    
    public void initCategory(String catName, ImportJSON jsonImportation){
        questions.put(catName, jsonImportation.readJSONFile(catName+".json"));
        questionsUsed.put(catName, new ArrayList<>());
    }
    
}
