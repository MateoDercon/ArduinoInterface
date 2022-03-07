package com.example.arduinointerface;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

import jssc.SerialPort;
import jssc.SerialPortException;

public class HelloApplication extends Application {

    //this object are out so that i can recall them
    static public jssc.SerialPort sp = new jssc.SerialPort("/dev/tty.usbmodem14201");


    Translator trans = new Translator();
    Alphabet alpha = new Alphabet();
    Pincontrol pin = new Pincontrol();
    public TranslatorSecondLevel trans2 = new TranslatorSecondLevel(sp);

    public HelloApplication() throws IOException {
    }

    public static void main(String[] args) throws SerialPortException, InterruptedException, IOException {
//this introduces my arduino method just to test, and introduces my serial port
        launch();
        try{
            sp.openPort();
            sp.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);


            //this helps it be centered at the beguining
            //sp.writeString("90");
            Thread.sleep(5000);


/*
            while(true){
         System.out.println("Enviando");

         Scanner sc = new Scanner(System.in);
         String st = sc.next();
         sp.writeString(fullData);

     }

 */
        } catch (SerialPortException e) {
            e.printStackTrace();
        }






        //Rotation ro = new Rotation("");

        //sp.addEventListener(SerialPortEventListener ,SerialPort.MASK_RXCHAR);
        //sp.addEventListener();
        //arduino ar = new arduino();

        //ar.runArduino(sp);

        //ar.rotate1("40",sp);




    }

    double opacity = 0;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root8 = FXMLLoader.load(getClass().getResource("Intro.fxml"));
        Scene introscene = new Scene(root8, 320, 240);

        //create button intro scene 1
        Button b1 = new Button();

        b1.setMinSize(200,200);
        b1.setText("Random Generator Practice");
        Button b2 = new Button();
        b2.setMinSize(200,200);
        b2.setText(" Text Reader");
        //first layout
        Group root4 = new Group();
        // StackPane root = new StackPane();
        VBox vb = new VBox();
        //root.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(b1, b2);
        // root.setLayoutX(stage.getMaxWidth()/2);
        root4.getChildren().add(vb);


        Scene scene1 = new Scene(root4,2000, 1000);
        b1.prefWidthProperty().bind(scene1.widthProperty().multiply(0.50));



/*




*/

        Label l1 = new Label();

        //second layout GAME 1
        Group root2= new Group();

        randomLetter rl = new randomLetter();

        rl.runArray();


        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long l) {

                /*
                long lastUpdate = System.nanoTime();
                long elapsedNanoSeconds = now - lastUpdate;

                // 1 second = 1,000,000,000 (1 billion) nanoseconds
                double elapsedSeconds = elapsedNanoSeconds / 1_000_000_000.0;
                lastUpdate = now;
                // ...

                // ...

                 */




            doHandle();

            }
            private void doHandle(){


                 opacity += 0.01;
                 l1.setOpacity(opacity);

                if (opacity == 1) {

                    stop();
                    System.out.println("Animation stopped");
                }


            }

        };
        //layout for  GAME 2
        Group root3= new Group();
        Button enterdata= new Button();
        enterdata.setText("Enter Data and Start Reading");
        TextArea ta= new TextArea();
        VBox vbox3= new VBox();
        vbox3.getChildren().addAll(ta,enterdata);
        root3.getChildren().addAll(vbox3);

        // ends here
        l1.setText( rl.getRandomLetter() );
        l1.setLayoutX(500);
        root2.getChildren().add(l1);
        Scene scene2 = new Scene(root2, 2160,1600);
        scene2.setFill(Color.rgb(87, 117, 144));

        Scene scene3 = new Scene(root3, 2160,1600);
        scene3.setFill(Color.rgb(87, 117, 144));

        //What happens if we press the buttons
        //this helps the thingy transport data towards my text file

//this is what goes in the thing but it is formated confusingly with the try and catch
//it is not very efficent becuase it creates pbject each time but for now it is the only way
// File file = new File("data.text");
//            file.createNewFile();
//            FileReader read1 = new FileReader(file);
//            FileWriter write2 = new FileWriter(file);
//            BufferedReader buff = new BufferedReader(read1);
//            PrintWriter writer = new PrintWriter(write2);
        enterdata.setOnMouseClicked(e -> {


//this method runs the translator second level with a complex looking try catch

            //it ends here and the main thing is the calling the method when i press the button
            File file= new File("data.text");
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            FileReader read1 = null;
            try {
                read1 = new FileReader(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            FileWriter write2 = null;
            try {
                write2 = new FileWriter(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            BufferedReader buff = new BufferedReader(read1);
            PrintWriter writer = new PrintWriter(write2);

            writer.write(ta.getText());
                writer.close();

                //try {


                        //sp.writeString(fullData);
                    //sp.writeString("0");
                     //   trans2.translate2();


                   // } catch (SerialPortException | IOException | InterruptedException ex) {
                   //     ex.printStackTrace();
                   // }


            }
        );

        b2.setOnMouseClicked(e -> {

                    animationTimer.start();
                    stage.setScene(scene3);
                }
        );

       b1.setOnMouseClicked(e -> {

                    animationTimer.start();
                    stage.setScene(scene2);
                }
        );

      scene2.setOnKeyPressed(e -> {
          l1.setText( rl.getRandomLetter() );
          opacity = 0;
          animationTimer.start();
              }
              );

        stage.setTitle("Hello!");
        stage.setFullScreen(false);
        stage.setScene(introscene);


        stage.show();

      //  arduino.runArduino();
    }





}