package org.collections;

import java.util.Objects;

public class Car {

    private final String color;

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car." + color;
    }
}
