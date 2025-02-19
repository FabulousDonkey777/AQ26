package org.example;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isHungry = true;

    public Cat() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Cat ran " + distance + " meters.");
        } else {
            System.out.println("Cat cannot run " + distance + " meters.");
        }
    }

    public void swim(int distance) {
        System.out.println("Cat cannot swim.");
    }

    public boolean eatFromBowl(FoodBowl bowl) {
        if (isHungry && bowl.getFoodAmount() > 0) {
            isHungry = false;
            bowl.decreaseFood(1);
            return true;
        }
        return false;
    }

    public boolean isHungry() {
        return isHungry;
    }
}
