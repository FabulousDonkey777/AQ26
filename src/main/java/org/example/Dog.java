package org.example;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog() {
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Dog ran " + distance + " meters.");
        } else {
            System.out.println("Dog cannot run " + distance + " meters.");
        }
    }

    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Dog swam " + distance + " meters.");
        } else {
            System.out.println("Dog cannot swim " + distance + " meters.");
        }
    }
}