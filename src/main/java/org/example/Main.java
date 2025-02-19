package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] words = {"book", "fig", "pen", "range", "book", "grape", "pen", "fruit",
                "fig", "range", "fruit", "grape", "zeal", "fake", "zeal",
                "range", "book", "grape", "apple", "zeal"};

        Counter wordCounter = new Counter(words);
        Map<String, Integer> wordCount = wordCounter.countWords();

        System.out.println("Уникальные слова и их частота:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "123-456-789");
        phoneBook.add("Petrov", "987-654-321");
        phoneBook.add("Sidorov", "555-555-555");
        phoneBook.add("Ivanov", "111-222-333");
        phoneBook.add("Petrov", "987-654-321");
        phoneBook.add("Sidorov", "123-456-789");


        System.out.println("Телефоны Иванова: " + phoneBook.get("Ivanov"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Petrov"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Sidorov"));



    }
}
