package org.sorting;

import java.util.Random;

public class SortingMain {

    public static void main(String[] args) {
        int[] ints = new int[30];

        fillArray(ints);
        semiSort(ints);
        printArray(ints);
    }

    private static void printArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static void fillArray(int[] ints) {
        Random random = new Random();

        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
            System.out.println(ints[i]);
        }
    }

    private static void semiSort(int[] ints) {
        int totalIterations = 0; //0
        int runs = 0; //0
        boolean swapHappens; // false

        for (int j = 0; j < ints.length; j++) {
            swapHappens = false;
            for (int i = 0; i < ints.length - 1 - runs; i++) {
                if (ints[i] > ints[i + 1]) {
                    System.out.println("swap values " + ints[i] + " " + ints[i + 1]);
                    int temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                    swapHappens = true;
                }
                totalIterations++;
            }
            if (!swapHappens) {
                break;
            }
            runs++;
        }

        System.out.println("Done in " + totalIterations);
    }
}
