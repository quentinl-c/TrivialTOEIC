/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author quentinlaporte-chabasse
 * Model of application
 * Manages : players, board, questions and answers
 */
public class Game extends Observable {
 
    private ArrayList<Player> players;
    private Board board;
    private boolean gameOver; //true when a player win a game
    private final HashMap<String, ArrayList<Question>> questions;
    private final HashMap<String, ArrayList<Question>> questionsUsed;
    private int dice;
    private int currentPlayer = -1;
    private String[] playerColor={"yellow","red","blue","green"};
    
    public Game(){
        this.players = new ArrayList<>();
        this.gameOver = false;
        this.questions = new HashMap<>();
        this.questionsUsed = new HashMap<>();
        this.board = new Board();
    }
    public void initGame(ImportJSON jsonImportation){
        initCategory("incomplete-sentences", jsonImportation);
        initCategory("vocabulary", jsonImportation);
        initCategory("reading-comprehension", jsonImportation);
        initCategory("error-recognition", jsonImportation);
        System.out.println(this.questions.get("incomplete-sentences").size() );
        System.out.println(this.questions.get("vocabulary").size() );
        System.out.println(this.questions.get("reading-comprehension").size() );
        System.out.println(this.questions.get("error-recognition").size() );
        
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
        player.setPos(this.players.size()*8+4);
        player.setColor(this.playerColor[this.players.size()]);
        this.players.add(player);
    }
    
    public void removePlayer(int index){
        this.players.remove(index);
    }
    public void initCategory(String catName, ImportJSON jsonImportation){
        questions.put(catName, jsonImportation.readJSONFile(catName+".json"));
        questionsUsed.put(catName, new ArrayList<>());
    }
    
    
    public Player getPlayer(int index){
        return this.players.get(index);
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    
    public void setScore(int index, int value){
        this.players.get(index).setScore(value);
    }
    
    public int getNumberofPlayers(){
        return this.players.size();
    }
    public void gameOver(){
        this.gameOver=true;
    }
    
    public int rollTheDice(){
    	this.currentPlayer = (this.currentPlayer + 1)%(this.players.size());
        this.dice=(int)(Math.random()*6) + 1;
        this.setChanged();
        this.notifyObservers();
        return this.dice;
        
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    public void clockwise(int shift,int playerIndex){
        this.getPlayer(playerIndex).setPos(this.getPlayer(playerIndex).getPos()-shift);
        setChanged();
        notifyObservers();
    }
    
    public int maxScore(){
    	int max = 0;
    	for (Player p : this.players){
    		if(p.getScore() >= max){
    			max = p.getScore();
    		}
    	}
    	return max;
    }
    
    public void counterClockwise(int shift,int playerIndex){
    	System.out.println("hey !");
        this.getPlayer(playerIndex).setPos(this.getPlayer(playerIndex).getPos()+shift);
        setChanged();
        notifyObservers();
    }
    
    public void incScore(int player, String category){
    	this.players.get(player).incPlayerScore(category);
    	this.checkGameOver();
    	this.setChanged();
    	this.notifyObservers();
    }
    
    public int getCurrentPlayer(){
    	return this.currentPlayer;
    }
    
    public String getCategory(){
    	return this.board.getCategory(this.getPlayer(this.currentPlayer).getPos());
    }
    
    public String getNextPlayer(){
    	int nexPlayerId = (this.currentPlayer + 1)%(this.players.size());
    	return this.getPlayer(nexPlayerId).getName();
    }
    
    public String getStat(){
    	String s="";
    	for(int i=0; i<4; i++){
    		s+="C"+Integer.toString( i+1)+" : "+Integer.toString(this.getPlayer(this.currentPlayer).getStat(i))+" | ";
    	}
    	return s;
    }
    
    public void checkGameOver(){
    	//the score must be greater than 20
    	if(this.players.get(this.currentPlayer).getScore() > 20){
    		boolean isGameOver = true;
    		for(int i = 0; i<4; i++){
    			//The player must have more than one good answer by category
    			if(this.players.get(this.currentPlayer).getStat(i) < 1){
    				isGameOver = false;
    			}
    		}
    		if(isGameOver){
    			this.gameOver = true;
    		}
    	}
    }
    
    public boolean isGameOver(){
    	return this.gameOver;
    }
    
    public int getDiceValue(){
    	return this.dice;
    }
    
    
    
}
