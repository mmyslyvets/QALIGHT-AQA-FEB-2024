package org.AbstracrionHomeWork;

public final class Samsung extends AbstractClassPhone{

    public static final String samsunglogo = "Samsung phone";

    @Override
    public void alarm() {
        System.out.println("alarm from Samsung");
    }

    @Override
    public void chargingPhone() {
        System.out.println("Samsung is charging");
    }

    public Samsung(){
    super.logo = samsunglogo;
    }
}