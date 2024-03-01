package org.session6;

//TODO: Create interface with two methods
//TODO: Abstract class that implements that interface, but implements only ONE method from it
//TODO: Create two child classes that extend AbstractClass, and implement the remaining method
//TODO: Add final string to abstract class and use its constructor to set its value
//TODO: Re-watch lection
public class BaseClass {

    public static void main(String[] args) {
        User adminDefault = User.generateUser();
    }

    public static void goTo(String dest) {
        goTo(dest, "my current location");
    }

    public static void goTo(String dest, String start) {
        goTo(dest, start, "nowhere");
    }

    public static void goTo(String dest, String start, String passingThrough) {
        System.out.println("Going from " + start +
                " to " + dest + " stopping at " + passingThrough);
    }

}
