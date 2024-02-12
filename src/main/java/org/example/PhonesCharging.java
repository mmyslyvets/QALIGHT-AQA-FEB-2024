package org.example;

public class PhonesCharging {

    public static void main(String[] args) {
        Phone[] phones = getPhones();
        chargePhones(phones);
        dischargePhones(phones);
    }

    public static Phone[] getPhones() {
        Phone[] phones = new Phone[4];

        for (int i = 0; i < phones.length; i++) {
            phones[i] = new Phone();
        }
        phones[0].model_name = "iphone";
        phones[1].model_name = "samsung";
        phones[2].model_name = "xiaomi";
        phones[3].model_name = "motorola";
        return phones;
    }

    public static void chargePhones(Phone[] phones) {
        for (int i = 0; i < phones.length; i++) {
            while (phones[i].isNeedCharge()) {
                phones[i].charging();
                System.out.println(phones[i].model_name + " phone is charging, charge level is " + phones[i].charge_level);

                if (phones[i].isFullCharged()) {
                    System.out.println(phones[i].model_name + " phone has full charged");
                }
            }
        }
    }

    public static void dischargePhones(Phone[] phones) {
        for (int i = 0; i < phones.length; i++) {
            while (phones[i].canBeDischarged()) {
                phones[i].discharging();
                System.out.println(phones[i].model_name + " phone is discharging, charge level is " + phones[i].charge_level);

                if (phones[i].isDischarged()) {
                    System.out.println(phones[i].model_name + " phone has fully discharged");
                }
            }
        }
    }
}
