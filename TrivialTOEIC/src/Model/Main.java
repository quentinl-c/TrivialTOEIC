/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author vincent
 */
public class Main {
    
    public static void main(String[] args) {
        
        /*Global settings for testing*/
        Game mainGame = new Game();
        Player player1 = new Player("Player1");
        mainGame.addPlayer(player1); // For the moment testing with only one player if you add more players be sure to change playGame() !
        
        
        /* JSON importation */
        ImportJSON jsonImportation = new ImportJSON();
        mainGame.initGame(jsonImportation);
        System.out.println(mainGame.randomQuestion("grammar"));
        
        /* Game loop*/      
        mainGame.playGame();
        System.out.println(mainGame.getPlayer(0).getStat(0));
        
    }
    
}
