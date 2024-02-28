package org.AbstracrionHomeWork;

public final class Xiaomi extends AbstractClassPhone {

    public static final String xiaomilogo = "Xiaomi phone";

    @Override
    public void alarm() {
        System.out.println("alarm alarm");
    }

    @Override
    public void chargingPhone() {
        System.out.println("Xiaomi is charging");
    }

    public Xiaomi(){
        super.logo = xiaomilogo;
    }
}
