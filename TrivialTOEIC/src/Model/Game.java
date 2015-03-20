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
        initCategory("grammar", jsonImportation);
        initCategory("vocabulary", jsonImportation);
        initCategory("incomplete-sentences", jsonImportation);
        initCategory("advanced-structures", jsonImportation);
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
        this.getPlayer(playerIndex).setPos(this.getPlayer(playerIndex).getPos()+shift);
        setChanged();
        notifyObservers();
    }
    
    public void incScore(int player, String category){
    	this.players.get(player).incPlayerScore(category);
    }
    
    public int getCurrentPlayer(){
    	return this.currentPlayer;
    }
    
    public String getCategory(){
    	return this.board.getCategory(this.getPlayer(this.currentPlayer).getPos());
    }
    /* Main loop */
    public void playGame(){
                
        /* Positionning players*/
        // need to randomize this when you add several players
        for(int i=0;i<players.size();i++){
            this.players.get(i).setPos(4+i*8);
        }
        
        /*Init of loop vars*/
        int currentPlayer = 0;//pl
        int turnsNb = 0;
        int currentPos;
        int moveClockwise;
        int moveAntiClockwise;
        String category;
        
        while(!this.gameOver){
            /* New  turn*/
            turnsNb++;
            if(currentPlayer==players.size()) // check if we looped over the players
                currentPlayer=0;
            System.out.println("Turn n° "+turnsNb);
            System.out.println("Player n° "+currentPlayer);//  Display Player turn
            
            /* Let's play*/
            currentPos=players.get(currentPlayer).getPos();
            rollTheDice();
            System.out.println("You rolled the dice and yout got : "+this.dice);
            if(currentPos+dice<32)
                moveClockwise=currentPos+dice;
            else
                moveClockwise=currentPos+dice-32;// looped over the board
            
            if(currentPos-dice>=0)
                moveAntiClockwise=currentPos-dice;
            else
                moveAntiClockwise=currentPos-dice+32;//same but anticlockwise
            
            //display where he can go
            System.out.println("Do you chose square n° "+moveClockwise+" or  square n° "+moveAntiClockwise);
            
            // move him on the square he chose ( for the moment he will automatically chose moveClockwise
            currentPos=moveClockwise;
            players.get(currentPlayer).setPos(currentPos);
            
            //  get the category
            category=board.getCategory(currentPos);
            // ask a random question 
            System.out.println(category);
            randomQuestion(category);
            
            //TODO 
            
            // - get and check the answer 
            // -
            // - check if game is over
            currentPlayer++;
            if(turnsNb==4)//end of game not implemented yet
                this.gameOver();
        }
    }
    
    
    
}
