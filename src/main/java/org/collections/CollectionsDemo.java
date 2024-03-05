package org.collections;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<String, Set<Car>> cars = new HashMap<>();
        Set<String> set = new HashSet<>();
        cars.put("Jane", new HashSet<>());
        cars.put("John", new HashSet<>());

        Car whiteCar = new Car("White");
        registerCarForOwner("Jack", whiteCar, cars);
        registerCarForOwner("John", new Car("Red"), cars);
        registerCarForOwner("John", new Car("Black"), cars);
        registerCarForOwner("Jane", new Car("Yellow"), cars);
        registerCarForOwner("Jane", whiteCar, cars);
        registerCarForOwner("Jane", new Car("Green"), cars);
        registerCarForOwner("Michael", new Car("Green"), cars);
        //printCars(cars);
        printOwnersGreenCar(cars);

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

//    public static void printCars(Map<String, Set<Car>> cars) {
    //       for (Map.Entry e : cars.entrySet()) {
//            System.out.println(e.getKey() + " has " + e.getValue());
//        }

    public static void printOwnersGreenCar(Map<String, Set<Car>> cars) {
        for (Map.Entry<String, Set<Car>> e: cars.entrySet()) {
            String ownerName = e.getKey();
            Set<Car> ownerCars = e.getValue();
            for (Car j : ownerCars) {
                if (j.toString().equals("Car.Green")) {
                    System.out.println(ownerName + " has " + ownerCars);
                }
            }
        }
    }


}
