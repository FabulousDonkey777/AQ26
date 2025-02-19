package org.example;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.printThreeWords();
        System.out.println();

        Task2 task2 = new Task2();
        task2.checkSumSign();
        System.out.println();

        Task3 task3 = new Task3();
        task3.printColor();
        System.out.println();

        Task4 task4 = new Task4();
        task4.compareNumbers();
        System.out.println();

        Task5 task5 = new Task5();
        System.out.println(task5.InRange(5, 10));
        System.out.println(task5.InRange(10, 3));
        System.out.println(task5.InRange(15, 10));
        System.out.println();

        Task6 task6 = new Task6();
        task6.checking(4);
        task6.checking(0);
        task6.checking(-100);
        System.out.println();

        Task7 task7 = new Task7();
        System.out.println("Is number -40 negative? " + task7.Negative(-50));
        System.out.println("Is number 242 negative? " + task7.Negative(242));
        System.out.println("Is number 0 negative? " + task7.Negative(0));
        System.out.println();

        Task8 task8 = new Task8();
        task8.print("ABCD", 10);
        System.out.println();

        Task9 task9 = new Task9();
        int[] years = {220, 19120, 20300, 23, 1600, 800, 37487, 243000, 1996};
        for (int b : years) {
            System.out.println(b + " is a leap year: " + task9.Year(b));
        }
        System.out.println();

        Task10 task10 = new Task10();
        task10.print();
        System.out.println();

        System.out.println();

        Task11 task11 = new Task11();
        task11.print();
        System.out.println();

        System.out.println();

        Task12 task12 = new Task12();
        task12.print();
        System.out.println();

        System.out.println();

        Task13 task13 = new Task13();
        task13.print();
        System.out.println();

        System.out.println();

        Task14 task14 = new Task14();
        task14.print();
    }
}