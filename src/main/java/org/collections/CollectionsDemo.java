package org.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<String, Set<Car>> cars = new HashMap<>();
        cars.put("Jane", null);
        cars.put("John", new HashSet<>());

        Car whiteCar = new Car("White");
        registerCarForOwner("Jack", whiteCar, cars);
        registerCarForOwner("John", new Car("Red"), cars);
        registerCarForOwner("John", new Car("Black"), cars);
        registerCarForOwner("Jane", new Car("Yellow"), cars);
        registerCarForOwner("Jane", whiteCar, cars);
        printCars(cars);

        //TODO: print owners names if he/she has a Green car
    }

    public static void registerCarForOwner(String ownerName, Car car, Map<String, Set<Car>> cars) {
        if (cars.containsKey(ownerName)) {
            cars.get(ownerName).add(car);
        } else {
            Set<Car> ownersCars = new HashSet<>();
            ownersCars.add(car);
            cars.put(ownerName, ownersCars);
        }
    }

    public static void printCars(Map<String, Set<Car>> cars) {
        for (Map.Entry e : cars.entrySet()) {
            System.out.println(e.getKey() + " has " + e.getValue());
        }
    }
}
