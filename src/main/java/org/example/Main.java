package org.example;

public class Main {
    public static void main(String[] args) {
        Sotrudnik sotrudnik = new Sotrudnik("Ivan Ivanovich Ivanov", "Engineer", "ivanov@example.com", "+7 123 456 78 90", 50000, 30);
        sotrudnik.printInfo();
        System.out.println();

        Sotrudnik[] sotrudnikiArray = new Sotrudnik[5];
        sotrudnikiArray[0] = new Sotrudnik("Ivan Ivanovich Dubov", "Plumber", "ivandub@mailbox.com", "892312313", 35000, 30);
        sotrudnikiArray[1] = new Sotrudnik("Petr Petrovich Petrov", "Manager", "petrov@mailbox.com", "892312313", 40000, 28);
        sotrudnikiArray[2] = new Sotrudnik("Sidor Sidorovich Sidorov", "Director", "sidorov@mailbox.com", "892312314", 60000, 45);
        sotrudnikiArray[3] = new Sotrudnik("Nikolai Nikolaevich Kuznetsov", "Analyst", "kuznetsov@mailbox.com", "892312315", 35000, 35);
        sotrudnikiArray[4] = new Sotrudnik("Anna Andreevna Smirnova", "Developer", "smirnova@mailbox.com", "892312316", 50000, 27);

        for (Sotrudnik a : sotrudnikiArray) {
            a.printInfo();
        }
        System.out.println();

        Park park = new Park();
        park.printAll();
    }
}