package org.example;

public class Task13 {
    public static void print() {

        int n = 5;
        int[][] array4 = new int[n][n];

        for (int i = 0; i < n; i++) {
            array4[i][i] = 1;
            array4[i][n - 1 - i] = 1;
        }


        printArray(array4);

    }

    public static void printArray(int[][] array4) {
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                System.out.print(array4[i][j] + " ");
            }
            System.out.println();

        }
    }
}