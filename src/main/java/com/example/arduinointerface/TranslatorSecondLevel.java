package com.example.arduinointerface;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

public class TranslatorSecondLevel {
    SerialPort sp;

    public TranslatorSecondLevel(SerialPort sp) {
        this.sp = sp;
    }
    //this method transform the array into the corresponding method, i could automate this procees with reflection but it could be slow



     void translate2() throws IOException, SerialPortException, InterruptedException {

        //I CAN ACCOUNT for the spaces if only I ignore any nulls, wait no nulls are pauses so they should run a puase method in alphabet
        ArrayList ar;
        Translator tl = new Translator();
        Alphabet al = new Alphabet();
        ar = tl.Translate();

        for(int i = 0; i<ar.toArray().length; i++){
            System.out.println(ar.get(i));
            if(ar.get(i).equals("a")){
                al.A(sp);
            }
            else if(ar.get(i).equals(" ")){
                //what about double spaces or triple???
                al.pause();
            }
            else if(ar.get(i).equals("b")){
                al.B(sp);
            }
            else{


            }
        }
    }
    void translate() throws IOException, SerialPortException {





    }
}
