package org.collections.set;

import org.collections.Car;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<Car> set = new HashSet<>();

        set.add(new Car("Red"));
        set.add(new Car("Green"));
        set.add(new Car("Red"));
        set.add(new Car("Green"));

        //System.out.println(set.size());

        for (Car s : set) {
            if (s.getColor().equals("Green")) {
                System.out.println(s.toString());
            }
        }
    }
}
