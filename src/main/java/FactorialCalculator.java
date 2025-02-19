public class FactorialCalculator {

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new     IllegalArgumentException("Факториал отрицательного числа не существует.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}