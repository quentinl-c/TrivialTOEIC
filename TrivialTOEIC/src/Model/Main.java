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
        Party mainParty = new Party();
        mainParty.initParty(jsonImportation);
        
        System.out.println(mainParty.randomQuestion("grammar"));
    }
    
}
