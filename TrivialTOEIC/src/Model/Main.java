/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.MainWindow;

/**
 *
 * @author vincent
 */
public class Main {
    
    public static void main(String[] args) {
        
        /*Global settings for testing*/
        Game mainGame = new Game();
        
        /* JSON importation */
        ImportJSON jsonImportation = new ImportJSON();
        mainGame.initGame(jsonImportation);
        
        /* Game loop*/
        
        //mainGame.playGame();
        
        MainWindow mw = new MainWindow(mainGame);
        
    }
    
}
