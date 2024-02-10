package org.example;

public class Car {

    public Engine engine;
    public String color;

    public int speed;

    public void accelerate() {
        if (speed <= 100) {
            speed = speed + 1;
        }
    }

    public void decelerate() {
        if (speed > 0) {
            speed = speed - 1;
        } else if (speed < 0) {
            speed = speed + 1;
        } else {
            System.out.println("Car is already parked");
        }
    }
}
