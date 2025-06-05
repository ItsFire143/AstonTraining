import org.example.FactorialOfNumber;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialOfNumberTestNG {

    @Test
    void testFactorialOfZero() throws IllegalAccessException {
        FactorialOfNumber calc = new FactorialOfNumber();
        assertEquals(calc.calculateFactorial(0), 1);
    }

    @Test
    void testFactorialFive() throws IllegalAccessException {
        FactorialOfNumber calc = new FactorialOfNumber();
        assertEquals(calc.calculateFactorial(5), 120);
    }

    @Test
    void testFactorialOfNegative(){
        FactorialOfNumber calc = new FactorialOfNumber();
        expectThrows(IllegalArgumentException.class, () -> calc.calculateFactorial(-1));
    }
}
