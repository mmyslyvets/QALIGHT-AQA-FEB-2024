package org.example;

public class Car {

    public final static String BRAND = "Ford";

    public Engine engine;

    public int speed;
    public String color;

    public static void smth() {
        System.out.println("Any car can do this");
        System.out.println("this is my homework3");
        System.out.println("this is my homework");
        System.out.println("this is my homework2");
    }

    public Car(String color, String engineVolume) {
        this.color = color;
        engine = new Engine(engineVolume);
        System.out.println("Construction of car " + color + " is done");
    }

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
