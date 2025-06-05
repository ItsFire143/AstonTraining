import org.example.FactorialOfNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialOfNumberTest {

    @Test
    void factorialOfZeroShouldBeOne() throws IllegalAccessException {
        FactorialOfNumber calc = new FactorialOfNumber();
        assertEquals(1, calc.calculateFactorial(0));
    }

    @Test
    void factorialOfFiveShouldBe120() throws IllegalAccessException{
        FactorialOfNumber calc = new FactorialOfNumber();
        assertEquals(120, calc.calculateFactorial(5));
    }

    @Test
    void factorialOfNegativeShouldThrowException() {
        FactorialOfNumber calc = new FactorialOfNumber();
        assertThrows(IllegalArgumentException.class, () -> calc.calculateFactorial(-1));
    }
}