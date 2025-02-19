package org.example;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();

        cat1.run(150);
        cat2.run(250);
        dog1.run(400);

        cat1.swim(5);
        dog1.swim(5);

        FoodBowl bowl = new FoodBowl(5);
        System.out.println("Food in the bowl: " + bowl.getFoodAmount());

        cat1.eatFromBowl(bowl);
        System.out.println("Cat 1 is full: " + !cat1.isHungry());
        System.out.println("Food in the bowl: " + bowl.getFoodAmount());

        cat2.eatFromBowl(bowl);
        System.out.println("Cat 2 is full: " + !cat2.isHungry());
        System.out.println("Food in the bowl: " + bowl.getFoodAmount());

        System.out.println("All animals: " + Animal.getAnimalCount());
        System.out.println("All cats: " + Cat.getCatCount());
        System.out.println("All dogs: " + Dog.getDogCount());
        System.out.println();
        System.out.println();
        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 6, "Blue", "Green");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        circle.printDetails();
        System.out.println();

        rectangle.printDetails();
        System.out.println();

        triangle.printDetails();
    }
}