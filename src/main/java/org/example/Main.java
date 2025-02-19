package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"5", "78", "45", "91"},
                {"23", "624", "7", "813"},
                {"934", "1034", "1134", "1344"},
                {"343", "23", "23", "123"}
        };

        String[][] invalidSizeArray = {
                {"5", "78", "45", "91"},
                {"23", "624", "7", "813"}
        };

        String[][] invalidDataArray = {
                {"5", "78", "45", "91"},
                {"23", "624", "7", "813"},
                {"934", "1034", "1134", "pop"},
                {"nufnuf", "23", "23", "123"}
        };

        try {
            int sum = ArrayProcessor.sumArray(validArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int sum = ArrayProcessor.sumArray(invalidSizeArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int sum = ArrayProcessor.sumArray(invalidDataArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}