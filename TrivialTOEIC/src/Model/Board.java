/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
/**
 *
 * @author vincent
 */
public class Board {
    
    private ArrayList<Square> board;

    public Board() {
        this.board= new ArrayList<>(32);
        for(int i=0;i<32;i++){
            /*
            Board generation
            Don't ask how it has been done, its done !
            How does it work? ;-)
            */
            if((i+4)%8==0){
                this.board.add(new Square("Base"));
            }else if(i%7==0||(i-4)%7==0){
                this.board.add(new Square("Category 1"));
            }else if((i-1)%7==0||(i-1-4)%7==0){
                this.board.add(new Square("Category 2"));
            }else if((i-2)%7==0||(i-2-4)%7==0){
                this.board.add(new Square("Category 3"));
            }else if((i-3)%7==0||(i-3-4)%7==0){
                this.board.add(new Square("Category 4"));
            }
        }
    }
    
    public String getCategory(int index){
        return this.board.get(index).getType();
    }
    
    
    
    
}
