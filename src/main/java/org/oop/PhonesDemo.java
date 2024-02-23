package org.oop;


public class PhonesDemo {

    public static void main(String[] args) {
        org.sorting.Car car = new org.sorting.Car();
        org.example.Car car1 = new org.example.Car("", "");

        CellPhone cellPhone = new CellPhone();
        AndroidPhoneV1 androidPhoneV1 = new AndroidPhoneV1();
        AndroidPhoneV2 androidPhoneV2 = new AndroidPhoneV2();
        IOSv1 ioSv1 = new IOSv1();
        WindowsPhoneV1 windowsPhoneV1 = new WindowsPhoneV1();

        cellPhone.color = "red";

//        cellPhone.acceptCall();
//        ioSv1.acceptCall();
//        windowsPhoneV1.acceptCall();
//        androidPhoneV1.acceptCall();
//        androidPhoneV1.scanFingerPrint();
//
//        androidPhoneV2.scanUsersFace();

        cellPhone.checkColor("green");
    }
}
