/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class Party {
    
    private ArrayList<Player> players;
    private boolean gameOver; //true when a player win a party
    private HashMap<String, ArrayList<String>> questions;
    
    public Party(){
        this.players = new ArrayList<>();
        this.gameOver = false;
        this.questions = new HashMap<>();
    }
    
    
    
    
}
