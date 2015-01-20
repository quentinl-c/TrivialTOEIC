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
    private int id; //Player number
    private int score;// player's score
    private int[] stat;// Payer's stat
    
    public Player(int id){
        this.id = id;
        this.score = 0;
        this.stat = new int[4]; // 4 categories
        //init stats
        for (int i = 0; i < 4; i++) {
            this.stat[i] =0;
        }
    }
}
