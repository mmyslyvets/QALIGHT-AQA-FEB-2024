package org.example;

public class Phones_charging {

    public static void main(String[] args){
        Phone[] phones = new Phone[4];
       // phones[0] = new Phone();
       // phones[1] = new Phone();
       // phones[2] = new Phone();
       // phones[3] = new Phone();

        for (int i = 0; i < phones.length; i++){
            phones[i] = new Phone();
            phones[i].charge_level = 0;
        }
        phones[0].model_name = "iphone";
        phones[1].model_name = "samsung";
        phones[2].model_name = "xiaomi";
        phones[3].model_name = "motorola";

        for (int i = 0; i < phones.length; i++){
            while (phones[i].charge_level < 100){
                phones[i].charging();
                System.out.println(phones[i].model_name + " phone is charging, charge level is " + phones[i].charge_level);
            }
        }

        for (int i = 0; i < phones.length; i++){
            while (phones[i].charge_level > 0){
                phones[i].discharging();
                System.out.println(phones[i].model_name + " phone is discharging, charge level is " + phones[i].charge_level);
                if (phones[i].charge_level <= 10)
                   break;
            }
        }
    }
}
