package org.example;

public class Task14 {
    public static void printArray(int len, int initialValue) {
        if (len < 0) {
            System.out.print("Array length must be positive. Please restart the program.");
        } else {
            int[] a = new int[len];
            for (int i = 0; i < len; i++) {
                a[i] = initialValue;
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void print() {
        int g = 5;
        int f = 6;
        printArray(g, f);
    }
}