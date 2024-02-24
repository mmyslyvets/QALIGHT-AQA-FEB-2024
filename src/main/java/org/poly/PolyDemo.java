package org.poly;

public class PolyDemo {
    public static void main(String[] args) {
        Tesla tesla = new Tesla();
        TeslaS teslas = new TeslaS();
        BMW bmw = new BMW();
        Ford ford = new Ford("1234567");

        useCar(tesla);
        useCar(ford);
        useCar(bmw);
        useCar(teslas);
    }

    public static void useCar(ICar iCar){
        iCar.goTo();
    }
}
