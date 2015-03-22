/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author quentinlaporte-chabasse
 */
public class Player{
    private String name;
    private int score;// Player's score
    private int[] stat;// Player's stat
    private int pos; // Player's position
    private String color;

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.stat = new int[4]; // 4 categories, by default Java inits it with zeros I knwo it... 

    }
    
   
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStat(int index) {
        return stat[index];
    }
    
    

    public void setStat(int index, int newValue ) {
        this.stat[index] = newValue;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int newPos) {
        if(newPos>31){
            this.pos=newPos-32;
        }else if(newPos<0){
            this.pos=newPos+32;
        }else{
            this.pos = newPos;
        }
        
    }
    

    
    public String toString(){
        return this.name +" : "+ this.score;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    
    public void incPlayerScore(String category){
    	this.score ++;
    	
    	switch (category){
    		case "incomplete-sentences":
    			stat[0]++;
    			break;
    		case "advanced-structures":
    			stat[1]++;
    			break;
    		case "reading-comprehension":
    			stat[2]++;
    			break;
                case "error-recognition":
                        stat[3]++;
                        break;
                default:
                        //nothing
                        break;
		}
    
    }
    
  
    
    public String getName(){
    	return this.name;
    }
    
    
}
