package com.example.arduinointerface;

import jssc.SerialPort;
import jssc.SerialPortException;


public class Pincontrol {

    public Pincontrol() {
    }

    /*
    boolean pin1;
    boolean pin2;
    boolean pin3;
    boolean pin4;
    boolean pin5;
    boolean pin6;

     */
/*
    public Pinscontrol(boolean pin1, boolean pin2, boolean pin3, boolean pin4, boolean pin5, boolean pin6) {
        this.pin1 = pin1;
        this.pin2 = pin2;
        this.pin3 = pin3;
        this.pin4 = pin4;
        this.pin5 = pin5;
        this.pin6 = pin6;
    }

 */

//this class looks messy but its quite simply, it is the same code and ideas three times for each three pair of pins
    //this is what I have to adjust depending on what i need, i still need to add the zero position in between i can do that after
    //each need a diferent method becuase each has a unique angle in which in works
public static String fullData= "";
public void columns(boolean pin1, boolean pin2, boolean pin3, boolean pin4, boolean pin5, boolean pin6, SerialPort sp) throws SerialPortException {
        //column one coding

        if(pin1 == true && pin2 == true){


        }
        else if(pin1 == false && pin2 == false){
            String x = "90";

        }
        else if(pin1 == false && pin2 == true){
            String x = "30";
           // ar.rotate1(x,sp);
        }
        else if(pin1 == true && pin2 == false){
            String x = "1";
            fullData = x;
        }
        else{
            System.out.println("wtf");
        }

        //second column

        if(pin3 == true && pin4 == true){


            //ar.rotate1(x,sp);
        }
        else if(pin3 == false && pin4 == false){
            String y = "0";
            fullData = fullData + y;
        }
        else if(pin3 == false && pin2 == true){
            String x = "0";
            //ar.rotate1(x,sp);
        }
        else if(pin3 == true && pin4 == false){
            String y = "8";
            fullData = fullData + y;
        }
        else{
            System.out.println("wtf");
        }
        //third column

        if(pin5 == true && pin6 == true){
            String x = "0";
            //ar.rotate1(x,sp);
        }
        else if(pin5 == false && pin6 == false){
            String z = "0";
            fullData = fullData + z;
            System.out.println(fullData);
           // ar.rotate1(x,sp);
        }
        else if(pin5 == false && pin6 == true){
            String x = "0";
           // ar.rotate1(x,sp);
        }
        else if(pin5 == false && pin6 == false){
            String x = "0";
           // ar.rotate1(x,sp);
        }
        else{
            System.out.println("wtf");
        }

    }

}








