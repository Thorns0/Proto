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
    public String CreateID(String file){
        String val = "0";
        FileReader fr = null;
        try {
            String line;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
                
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
}
