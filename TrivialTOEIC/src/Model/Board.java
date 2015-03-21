/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author vincent
 */
public class Board {
    
    private ArrayList<Square> board;
    private final HashMap<Integer,int[]> correspondance;
            
    public Board() {
        this.board= new ArrayList<>(32);
        for(int i=0;i<32;i++){
            /*
            Board generation
            Don't ask how it has been done, its done !
            */
            if((i+4)%8==0){
                this.board.add(new Square("Base"));
            }else if(i%7==0||(i-4)%7==0){
                this.board.add(new Square("incomplete-sentences"));
            }else if((i-1)%7==0||(i-1-4)%7==0){
                this.board.add(new Square("advanced-structures"));
            }else if((i-2)%7==0||(i-2-4)%7==0){
                this.board.add(new Square("reading-comprehension"));
            }else if((i-3)%7==0||(i-3-4)%7==0){
                this.board.add(new Square("grammar"));
            }
        }
        
        /*
        Correspondance Hasmap generation
        It creates the correspondance between board index and matrix tuples
        Don't ask how it as been done neither.
        */
        this.correspondance = new HashMap<>(32);
        for(int i = 0 ; i<32;i++){
            if(i<9){
                int[] tempArray = {0,i};
                this.correspondance.put(i, tempArray);
            }else if (i<17){
                int[] tempArray = {(i!=16)?i%8:8,8};
                this.correspondance.put(i, tempArray);
            }else if (i<25){
                int[] tempArray = {8,(i!=24)?8-i%8:0};
                this.correspondance.put(i, tempArray);
            }else{
                int[] tempArray = {8-i%8,0}; 
                this.correspondance.put(i, tempArray);
            }               
        }
    }
    
    public HashMap getCorrHashmap(){
        return this.correspondance;
    }
    
    public String getCategory(int index){
        return this.board.get(index).getType();
    }
    
    public Integer getIndexFromVal(int[] values){
        for (Map.Entry<Integer, int[]> entrySet : correspondance.entrySet()) {
                Integer key = entrySet.getKey();
                int[] value = entrySet.getValue();
                
                if (Arrays.equals(values, value)){
                    return key;
                }
            }
        return -1;
    }
    
    public int[] getValfromIndex(int index){
        return correspondance.get(index);
    }
}
