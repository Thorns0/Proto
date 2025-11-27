/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adg19f
 */
public class Functions {
    public String GetLastLine(String file){
        String val = "0";
        FileReader fr = null;
        try {
            String Line;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            try {
                while((Line=br.readLine())!=null){
                    val = Line;
                }
            } catch (IOException ex) {
                Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return val;
    }
    
    public int CreateID(String file){
        String val = GetLastLine(file);
        String [] store;
        int num = 1;
        if(val.equals("0")){
            return 1;
        }
        else{
            store = val.split(",");
            val = store[0];
            val = val.substring(2);
            num = Integer.parseInt(val);
            num++;
            return num;
        }
    }
}
