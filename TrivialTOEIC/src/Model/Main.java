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
        ImportJSON jsonImportation = new ImportJSON();
        Game mainGame = new Game();
        mainGame.initGame(jsonImportation);
        
        System.out.println(mainGame.randomQuestion("grammar"));
        
        
        
    }
    
}
