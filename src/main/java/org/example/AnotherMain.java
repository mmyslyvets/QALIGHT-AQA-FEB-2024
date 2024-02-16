package org.example;

public class AnotherMain {

    public static void main(String[] args) {
        String s = getString();
        printString(s);
    }

    public static void printString(String s) {
//        if (s == null){
//            return;
//        }
        System.out.println(s.length());
    }

    public static String getString() {
        return null;
    }
}
