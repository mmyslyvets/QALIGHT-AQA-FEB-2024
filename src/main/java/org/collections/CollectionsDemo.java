package org.collections;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
//        Map<String, Set<Car>> cars = new HashMap<>();
//        cars.put("Jane", null);
//        cars.put("John", new HashSet<>());
//
//        Car whiteCar = new Car("White");
//        registerCarForOwner("Jack", whiteCar, cars);
//        registerCarForOwner("John", new Car("Red"), cars);
//        registerCarForOwner("John", new Car("Black"), cars);
//        registerCarForOwner("Jane", new Car("Yellow"), cars);
//        registerCarForOwner("Jane", whiteCar, cars);
        printCars();

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

    public static void printCars() {
        Car car = new Car("Red", new Battery());
        if (car.getColor().equals("Red")) {
            System.out.println("car is red");
        }
    }
}
