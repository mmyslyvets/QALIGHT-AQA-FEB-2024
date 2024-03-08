package org.collections;

public class Car extends CarKeys {

    private final String color;

    public Car(String color, Battery battery) {
        super(battery);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

//    @Override
//    public String toString() {
//        return "Car." + color;
//    }
}
