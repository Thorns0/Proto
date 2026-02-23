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
    // a function to get the contents of the last line in a file
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
    
    //Creating the number fo either swimmerID or coachID to ensure that they are all unique
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
    
    //counting the number of swimmers in a certain group
    public int countFile(String file, String find){
        FileReader fr = null;
            int num = 0;
        try {
            String Line;
            String [] store;
            String ID;
            String Group;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            try {
                while((Line=br.readLine())!=null){
                    store = Line.split(",");
                    ID = store[0];
                    Group = ID.substring(0, 2);
                    if(Group.equals(find)){
                        num++;
                    }
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
        return num;
    }
    
    //Finding the number of line in a file
    public int lineInFile(String file){
        int num = 0;
        String Line;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            try {
                while((Line = br.readLine())!=null){
                     num++;
                }
                return num;
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
        return num;
    }
    
    //printing a 2D array to the system
    public void print2darry(String[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int y=0;y<arr[i].length;y++){
                System.out.print(arr[i][y]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
    
    //Checking if the current user is an approved member of the committe to see if they're able to open the window
    public Boolean CheckComMem(String user){
        String Line;
        String [] store;
        Boolean inFile = false;
        FileReader fr = null;
        try {
            fr = new FileReader("ComMembers.txt");
            BufferedReader br = new BufferedReader(fr);
            try {
                while((Line = br.readLine())!=null){
                    store = Line.split(",");
                    if(user.equals(store[1])){
                        inFile = true;
                    }
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
        return inFile;
    }
    
    //Checking if an item in a certain position of a file is a Yes or a No and returning the coaches name if its a yes
    //Use to see what days coaches are avalible to be on poolside on each day
    public String [] AvalibleForDay(String file, int num){
        Functions fun = new Functions();
        FileReader fr = null;
        try {
            String [] arry = new String [fun.lineInFile(file)];
            String [] temp;
            int i = 0;
            String Line;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            try {
                //reading through file checing to see if specific item is Yes to check if they are avalible
                while((Line=br.readLine())!=null){
                    temp=Line.split(",");
                    if(temp[num].equals("Yes")){
                        arry[i] = temp[4];
                        i++;
                    }
                }
                return arry;
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
        String [] fail = null;
        return fail;
    }
}
