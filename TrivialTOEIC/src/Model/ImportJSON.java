/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author quentinlaporte-chabasse
 */
public class ImportJSON {
    JSONParser parser;

    public ImportJSON() {
        this.parser = new JSONParser();
        
    }
    
    public ArrayList<Question> readJSONFile(String dir){
        //Definition of categories imported from JSON file 
  
        ArrayList<Question> questions = new ArrayList<>();
        
        try {
            JSONArray questionsArray = (JSONArray) this.parser.parse(new FileReader(dir));
            
            for(Object obj : questionsArray){
                
                JSONObject question = (JSONObject) obj;
                Question questionObj = new Question((String) question.get("question"));
                questionObj.setContent((String) question.get("content"));
                questionObj.setRightAnswer((String) question.get("rightAnswer"));
                JSONArray answers = (JSONArray) question.get("answers");
                for(Object a : answers){
                    questionObj.setAnswer((String)a);
                }
                questions.add(questionObj);

            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ImportJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
        
    }
  
}
