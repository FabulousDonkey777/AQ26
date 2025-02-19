package org.example;

public class Task11 {
    public static void print() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}