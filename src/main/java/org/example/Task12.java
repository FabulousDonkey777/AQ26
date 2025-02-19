package org.example;

public class Task12 {
    public static void print() {
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }

        for (int num : array3) {
            System.out.print(num + " ");
        }
    }
}