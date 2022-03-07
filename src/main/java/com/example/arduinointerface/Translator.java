package com.example.arduinointerface;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Translator {
    public Translator() throws IOException {
    }
    //this code get input of a text and transform each letter into an arraylist then it returns the follwing
    //I still need to make it account for spaces in between the lines, for now it only works if all the text is glued together
    File file = new File("data.text");
    ArrayList<String> letters = new ArrayList<String>();
    FileReader read1 = new FileReader(file);
    FileWriter write2 = new FileWriter(file,true);
    BufferedReader buff = new BufferedReader(read1);
    PrintWriter print = new PrintWriter(write2);

public void print(String text) throws IOException {
    FileWriter write4 = new FileWriter(file);
    write4.write(text);
}
    //the code above this comment: this will print whatever i want into the data text or text file im using
    public ArrayList<String>  Translate() throws IOException {
        String line;

        // while((buff.readLine()) != null){

        for(int i = 0; i< file.length() ; i++){
            line = buff.readLine();
            if(line != null){
                String[] words;
                words = line.toLowerCase().split("");
                letters.addAll(Arrays.asList(words));
            }
        }

        System.out.println(letters);
        return(letters);

    }

}
