package org.example;

interface Shape {
    double calculatePerimeter();

    double calculateArea();

    String getFillColor();

    String getBorderColor();

    default void printDetails() {
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Square: " + calculateArea());
        System.out.println("Filling colour: " + getFillColor());
        System.out.println("Boundary colour: " + getBorderColor());
    }
}
