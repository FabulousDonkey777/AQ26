package org.example;

public class Task3 {
    public static void printColor() {
        int value = 150;
        if (value < 0) {
            System.out.println("Red");
        } else if (value >= 0 && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }
}