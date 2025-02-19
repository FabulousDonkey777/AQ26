package org.example;

import java.util.ArrayList;

public class Park {
    private ArrayList<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>(); // Adding some default attractions
        attractions.add(new Attraction("Carousel", "18-19", 5));
        attractions.add(new Attraction("Ferris Wheel", "19-20", 10));
        attractions.add(new Attraction("Horses", "19-21", 15));
        attractions.add(new Attraction("Roller Coaster", "21-24", 500));
    }

    public void addAttraction(String name, String schedule, int cost) {
        attractions.add(new Attraction(name, schedule, cost));
    }

    class Attraction {
        private String name;
        private String schedule;
        private int cost;

        public Attraction(String name, String schedule, int cost) {
            this.name = name;
            this.schedule = schedule;
            this.cost = cost;
        }

        public String getInfo() {
            return "Attraction information: " + name + " " + schedule + " " + cost;
        }
    }

    public void printInfo() {
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getInfo());
        }
    }

    public static void printAll() {
        Park park = new Park();
        park.printInfo();
        // Adding a new attraction
        park.addAttraction("Water Slide", "10-22", 300);
        System.out.println("After adding a new attraction:");
        park.printInfo();
    }
}