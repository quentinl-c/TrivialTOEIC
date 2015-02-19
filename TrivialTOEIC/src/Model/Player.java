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
public class Player {
    private String name;
    private int score;// Player's score
    private int[] stat;// Player's stat
    private int x,y; // Player's position
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
