package org.poly;

public interface ICar {

    String carModel = "Ford";

    void turnLeft();

    void turnRight();

    default void goTo() {
        System.out.println("go to some place");
        turnRight();
        turnLeft();
    }
}
