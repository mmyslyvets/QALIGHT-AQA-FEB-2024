package org.example;

public class Main {

    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car();
        cars[1] = new Car();
        cars[2] = new Car();
        cars[3] = new Car();
        cars[4] = new Car();

        for (int i = 0; i < cars.length; i++) {
            cars[i].speed = 0;
        }

        cars[0].color = "red";
        cars[1].color = "green";
        cars[2].color = "yellow";
        cars[3].color = "blue";
        cars[4].color = "black";


        for (int i = 0; i < cars.length; i++) {
            while (cars[i].speed <= 100) {
                cars[i].accelerate();
                System.out.println(cars[i].color + " car speed is " + cars[i].speed);
            }
        }

        for (int i = 0; i < cars.length; i++) {
            while (cars[i].speed > 0) {
                cars[i].decelerate();
                System.out.println(cars[i].color + " car speed is " + cars[i].speed);
            }
        }


//        int i = 1000;
//        while (i < 100) {
//            System.out.println(i);
//        }
//
//        do {
//            System.out.println(i);
//        } while (i < 100);


//        String[] strings = new String[5];//0,1,2,3,4
//        strings[0] = "a";
//        strings[1] = "b";
//        strings[2] = "c";
//        strings[3] = "d";
//        strings[4] = "e";
//        int i = -50;
        // 1. create i = 0
        // 2. check condition i < 10
        // 3. execute code
        // 4. i++
//        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//        }

//        for (int j = 100; j > 0; j--) {
//            System.out.println(j);
//        }


//        int ten = 10;
//        int five = 5;
//        int four = 4;
//
//        if (
//                (
//                        compareNumbers(four, five) || compareNumbers(ten, five)
//                )
//                        && (
//                        compareNumbers(five, ten) || compareNumbers(five, four)
//                )
//        ) {
//            System.out.println("it works");
//        } else {
//            System.out.println("condition not valid");
//        }
    }

    public static boolean compareNumbers(int i, int j) {

        return i > j;
    }
}