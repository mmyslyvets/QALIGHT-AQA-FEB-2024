package org.example;

public class Phone {

    public String model_name;

    public int charge_level;

    public void charging(){
       if (charge_level < 80){
           charge_level=charge_level + 10;
       } else if (charge_level >= 80 || charge_level <= 100) {
           charge_level = charge_level + 1;
       }
    }

    public void discharging(){
        if (charge_level > 0){
            charge_level = charge_level - 1;
        }

    }
}
