package com.example.arduinointerface;

public class RotationNA {
        private String rotation;
//this only helps keep rotation values tidy although neccesary
        public RotationNA(String rotation) {
            this.setRotation(rotation);
        }

        public String getRotation() {
            return rotation;
        }

        public void setRotation(String rotation) {
            this.rotation = rotation;
        }
    }

