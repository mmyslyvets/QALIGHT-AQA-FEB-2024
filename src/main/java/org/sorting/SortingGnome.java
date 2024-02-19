package org.sorting;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SortingGnome {

    public static void main(String[] args) {
        int[] gnome = new int[40];
        fillGnomes(gnome);
        System.out.println("_____");
        sortGnomes(gnome);
        printSortedArray(gnome);

    }

    private static void fillGnomes(int @NotNull [] gnome) {
        Random random = new Random();

        for (int i = 0; i < gnome.length; i++) {
            gnome[i] = random.nextInt(100);
            System.out.println(gnome[i]);
        }
    }

    private static void printSortedArray(int @NotNull [] gnome) {
        for (int i = 0; i < gnome.length; i++)
            System.out.println(gnome[i]);
    }

    private static void sortGnomes(int @NotNull [] gnome) {
        for (int i = 0; i < gnome.length; i++) {
            if(i == 0){
                continue;
            }
            else if (gnome[i] < gnome[i - 1]) {
                int temp = gnome[i];
                gnome[i] = gnome[i - 1];
                gnome[i - 1] = temp;
                i = i - 2;
            }
        }
    }
}
