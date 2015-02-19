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
public class Game {
 
    private ArrayList<Player> players;
    private boolean gameOver; //true when a player win a game
    private final HashMap<String, ArrayList<Question>> questions;
    private final HashMap<String, ArrayList<Question>> questionsUsed;
    private int dice;
    
    public Game(){
        this.players = new ArrayList<>();
        this.gameOver = false;
        this.questions = new HashMap<>();
        this.questionsUsed = new HashMap<>();
    }
    public void initGame(ImportJSON jsonImportation){
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
    
    public void addPlayer(Player player){
        this.players.add(player);
    }
    
    public void initCategory(String catName, ImportJSON jsonImportation){
        questions.put(catName, jsonImportation.readJSONFile(catName+".json"));
        questionsUsed.put(catName, new ArrayList<>());
    }
    
    
    public Player getPlayer(int index){
        return this.players.get(index);
    }
    
    public void gameOver(){
        this.gameOver=true;
    }
    
    public void rollTheDice(){
        this.dice=(int)(Math.random()*6) + 1;
    }
    
    /* Main loop */
    public void playGame(){
        
        /* Positionning players*/
        // need to randomize this when you add several players
        this.players.get(0).setX(0);
        this.players.get(0).setY(0);
        
        while(!this.gameOver){
            // - Iterate over players ArrayList
            // - Display Player turn
            rollTheDice();
            System.out.println("You rolled the dice and yout got : "+this.dice);
            // - tell him where he can go 
            // - move him on the square he chose
            // - get the category
            // - ask a random question 
            // - get and check the answer 
            // -
            // - check if game is over
            this.gameOver();
        }
    }
    
    
    
}
