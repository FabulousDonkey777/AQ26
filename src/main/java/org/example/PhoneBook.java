package org.example;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook = new HashMap<>();
    private final Set<String> uniqueNumbers = new HashSet<>();

    public void add(String surname, String phoneNumber) {
        if (uniqueNumbers.contains(phoneNumber)) {
            System.out.println("Ошибка: номер " + phoneNumber + " уже используется.");
            return;
        }

        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>());

        List<String> numbers = phoneBook.get(surname);
        if (!numbers.contains(phoneNumber)) {
            numbers.add(phoneNumber);
            uniqueNumbers.add(phoneNumber);
            System.out.println("Контакт " + surname + " с номером " + phoneNumber + " добавлен.");
        } else {
            System.out.println("Ошибка: номер " + phoneNumber + " уже добавлен для фамилии " + surname + ".");
        }
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    public void displayContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("Телефонный справочник пуст.");
        } else {
            System.out.println("Телефонный справочник:");
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                System.out.println("Фамилия: " + entry.getKey() + ", Номера: " + entry.getValue());
            }
        }
    }
}