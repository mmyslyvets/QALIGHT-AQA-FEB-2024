package org.example;

public class Main {

    public String value;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Car.BRAND);
        Car.smth();

        Car[] cars = new Car[7];
        cars[0] = new Car("red", "2.0");
        cars[1] = new Car("green", "1.0");
        cars[2] = new Car("yellow", "1.8");
        cars[3] = new Car("blue", "3.0");
        cars[4] = new Car("black", "1.2");
        cars[5] = new Car("purple", "3.0");
        cars[6] = new Car("white", "5.0");


//        for (int i = 0; i < cars.length; i++) {
//            if (i > 3) {
//                break;
//            }
//            if (cars[i].color.equals("red")) {
//                System.out.println("This is red car");
//            } else if (cars[i].color.equals("green")) {
//                System.out.println("This is green car");
//            } else if (cars[i].color.equals("yellow")) {
//                System.out.println("This is yellow car");
//            } else if (cars[i].color.equals("blue")) {
//                System.out.println("This is blue car");
//            } else if (cars[i].color.equals("black")) {
//                System.out.println("This is black car");
//            } else {
//                System.out.println("This car is not red, green, blue, yellow or black");
//            }
//        }

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("===================================================");
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//        String s = "";

//        for (int i = 0; i < cars.length; i++) {
//            switch (cars[i].color) {
//                case "blue":
//                    System.out.println("Blue car is found!");
//                    System.out.println("Blue car engine volume is " + cars[i].engine.volume);
//                    break;
//                case "green":
//                    System.out.println("Green car is found!");
//                    System.out.println("Green car engine volume is " + cars[i].engine.volume);
//                    break;
//                case "yellow":
//                    System.out.println("Yellow car is found!");
//                    System.out.println("Yellow car engine volume is " + cars[i].engine.volume);
//                    break;
//                case "red":
//                    System.out.println("Red car is found!");
//                    System.out.println("Red car engine volume is " + cars[i].engine.volume);
//                    break;
//                case "black":
//                    System.out.println("Black car is found!");
//                    System.out.println("Black car engine volume is " + cars[i].engine.volume);
//                    break;
//                default:
//                    System.out.println("Car of another colour found");
//                    System.out.println("That car's engine volume is " + cars[i].engine.volume);
//            }
//        }
//        smth("a");
//        smth("c");
//        smth("e");
//        smth("g");

    }

//    public static void smth(String s) {
//        System.out.println("=====================================");
//        System.out.println("Evaluating " + s);
//        String result = "";
//        switch (s) {
//            case "a":
//                result += "start_of_string_";
//            case "b":
//                result += "subset_1_";
//            case "c":
//                result += "subset_2_";
//            case "d":
//                result += "subset_3_";
//            case "e":
//                result += "subset_4_";
//            default:
//                result += "end_of_string";
//        }
//        System.out.println(result);
//
//    }

    public static boolean compareNumbers(int i, int j) {
        return i > j;
    }

    public static void compareNumbers2(int i, int j) {
        System.out.println();
    }
}