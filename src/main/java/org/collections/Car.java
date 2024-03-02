package org.collections;

public class Car {

    private final String color;

    public Car(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car." + color;
    }
}
