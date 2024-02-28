package org.AbstracrionHomeWork;


public class HomeworkAbstraction {
    public static void main (String[] args){
        Samsung samsung1 = new Samsung();
        Xiaomi xiaomi1 = new Xiaomi();
        samsung1.alarm();
        xiaomi1.alarm();
        samsung1.chargingPhone();
        xiaomi1.chargingPhone();

    }
}

