/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
        Object obj;
        try {
            obj = parser.parse(new FileReader("test.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray quest = (JSONArray) jsonObject.get("grammar");
            Iterator<JSONObject> iterator = quest.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().get("question"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ImportJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ImportJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
