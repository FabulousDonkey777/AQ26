import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0))     ;
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
        assertEquals(720, FactorialCalculator.calculateFactorial(6));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Факториал отрицательного числа не существует.")
    public void testFactorialOfNegativeNumber() {
            FactorialCalculator.calculateFactorial(-1);
    }
}