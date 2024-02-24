package org.sorting;

public class Car {

    public String color;

    private final String serialNumber;

    public Car(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car c = (Car) obj;
            return this.color != null && this.color.equals(c.color);
//            return this.color != null && this.color.equals(((Car) obj).color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
