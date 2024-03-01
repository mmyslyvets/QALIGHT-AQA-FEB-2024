package org.sorting;

public class CarV2 extends Car {
    public CarV2(String serialNumber) {
        super(serialNumber);
        String s = super.getSerialNumber();
    }

    public String getSerialNumber() {
        return "serialNumber";
    }
}
