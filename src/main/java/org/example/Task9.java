package org.example;

public class Task9 {

    public static boolean Year(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

}