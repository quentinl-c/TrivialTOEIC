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
 */
public class Party {
    
    private ArrayList<Player> players;
    private boolean gameOver; //true when a player win a party
    private HashMap<String, ArrayList<Question>> questions;
    
    public Party(){
        this.players = new ArrayList<>();
        this.gameOver = false;
        this.questions = new HashMap<>();
    }
    public void initParty(ImportJSON jsonImportation){
        questions.put("grammar", jsonImportation.readJSONFile("grammar.json"));
        questions.put("vocabulary", jsonImportation.readJSONFile("vocabulary.json"));
        System.out.println(questions);
    }
    
    public Question randomQuestion(String category){
        if(this.questions.containsKey(category)){
            int maxBound = questions.get(category).size() ;
            System.out.println(maxBound);
            Random rand = new Random();
            int randomNum = rand.nextInt(maxBound);
   
        return this.questions.get(category).get(randomNum);
        }else{
            return null;
        }   
    }
    
    public void addPlayer(String name){
        int id = this.players.size();
        Player currentPlayer = new Player(id, name);
        this.players.add(currentPlayer);
    }
    
    
}
