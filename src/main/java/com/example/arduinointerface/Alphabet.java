package com.example.arduinointerface;

import jssc.SerialPort;
import jssc.SerialPortException;

import static com.example.arduinointerface.Pincontrol.fullData;

public class Alphabet {
    Pincontrol pincontrol1 = new Pincontrol();
    arduino ar = new arduino();
    //this part of the code call out the columns for each letter, each cobination of booleans represents the pins
    //pin1 is the one at the top far left, true means on, this is sent to the pincntrol which rotates the motor

    void A(SerialPort sp) throws SerialPortException {
        System.out.println("Method alphabet printing A");
        pincontrol1.columns(true,false,false,false,false,false,sp);
        sp.writeString(fullData);


    }
    void B(SerialPort sp) throws SerialPortException {
        System.out.println("Method alphabet printing B");
        pincontrol1.columns(true,false,true,false,false,false,sp);
        sp.writeString(fullData);

    }
    void pause() throws InterruptedException {
        //i should add this thingy here:Thread.sleep(5000); ill figure how to do it after
        System.out.println("pause");
        Thread.sleep(1000);

    }


}
