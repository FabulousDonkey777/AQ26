package org.example;

public class FoodBowl {
    private int foodAmount;

    public FoodBowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0);
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        foodAmount = Math.max(foodAmount - amount, 0);
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }
}