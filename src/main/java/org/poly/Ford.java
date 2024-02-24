package org.poly;

import org.sorting.Car;

public class Ford extends Car implements ICar, ITransport {
    public Ford(String serialNumber) {
        super(serialNumber);
    }

    public void turnLeft() {
        System.out.println("Ford turns Left");
    }

    public void turnRight() {
        System.out.println("Ford turns Right");
    }

    public void stop(String stationName) {
        System.out.println("Stopping at " + stationName);
    }

}
