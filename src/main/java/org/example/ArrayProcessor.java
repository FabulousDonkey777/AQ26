package org.example;

public class ArrayProcessor {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }

        int sum = 0;
        StringBuilder errors = new StringBuilder();
        boolean b = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    errors.append("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j] + "\n");
                    b = true;
                }
            }
        }

        if (b) {
            throw new MyArrayDataException(errors.toString());
        }

        return sum;
    }
}