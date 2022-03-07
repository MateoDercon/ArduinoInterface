package com.example.arduinointerface;
import jssc.SerialPort;
import jssc.SerialPortException;

import javax.swing.*;

public class arduino {





        public static void runArduino(SerialPort sp) {
//this code is no longer very important but it is a reference on how to call my arduino code, it is helpful

            try{
            //sp.openPort();

            //sp.setParams(SerialPort.BAUDRATE_115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            //sp.addEventListener(new ,SerialPort.MASK_RXCHAR);
//Thread.sleep(1500);
            RotationNA ro = new RotationNA("");


            while(true){



                //Scanner sc= new Scanner(System.in);
                JOptionPane jp= new JOptionPane();
                int rotation = Integer.parseInt(JOptionPane.showInputDialog("Enter rotation"));
                System.out.println("Introduce com.example.arduinointerface.arduino.Rotation");
                //rotation = sc.nextInt();
                sp.writeString(ro.getRotation());
                Thread.sleep(5000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }

    public void rotate1(String angle,SerialPort sp) throws SerialPortException {
            sp.writeString(angle);

    }
}



