package org.AbstracrionHomeWork;

public abstract class AbstractClassPhone implements PhoneDefault {

    protected String logo = "Default logo";


    public void AbstractPage(String logo) {
        this.logo = logo;

    }
    @Override
    public abstract void chargingPhone();
}
