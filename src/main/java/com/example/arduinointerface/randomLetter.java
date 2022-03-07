package com.example.arduinointerface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomLetter {
    List<String> l1 = new ArrayList<String>();

    public void runArray(){
        l1.add("A");  l1.add("F");
        l1.add("B");  l1.add("G");
        l1.add("C");  l1.add("H");
        l1.add("D");  l1.add("I");
        l1.add("E");  l1.add("J");

        l1.add("K");  l1.add("P");
        l1.add("L");  l1.add("Q");
        l1.add("M");  l1.add("R");
        l1.add("N");  l1.add("S");
        l1.add("O");  l1.add("T");

        l1.add("U");  l1.add("Z");
        l1.add("V");
        l1.add("W");
        l1.add("X");
        l1.add("Y");
    }
    public String getRandomLetter(){
        Random rm = new Random();
        return (l1.get(rm.nextInt(22)));
    }
    public List<String> getL1() {
        return l1;
    }
}
