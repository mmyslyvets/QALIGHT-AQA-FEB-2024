package org.example;

public class Phone {

    public String model_name = "";

    public int charge_level = 0;

    public boolean isFullCharged() {
        return charge_level == 100;
    }

    public boolean isDischarged() {
        return charge_level == 10;
    }

    public boolean isNeedCharge() {
        return charge_level < 100;
    }

    public boolean canBeDischarged() {
        return charge_level > 10;
    }

    public void charging() {
        boolean hasSuperCharge = charge_level < 80;
        if (hasSuperCharge) {
            charge_level = charge_level + 10;
        } else {
            charge_level = charge_level + 1;
        }
    }

    public void discharging() {
        if (charge_level <= 0)
            return;

        charge_level = charge_level - 1;
    }

}
