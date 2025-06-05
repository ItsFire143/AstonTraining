import org.example.ArithmeticOps;
import org.example.FactorialOfNumber;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticOpsTestNG {

    @Test
    public void testAdd(){
        ArithmeticOps calc = new ArithmeticOps();
        assertEquals(calc.add(2,3), 5);
    }

    @Test
    public void testSub(){
        ArithmeticOps calc = new ArithmeticOps();
        assertEquals(calc.substract(5,2), 3);
    }

    @Test
    public void testMulty(){
        ArithmeticOps calc = new ArithmeticOps();
        assertEquals(calc.multiply(4, 5), 20);
    }

    @Test
    public void testDiv(){
        ArithmeticOps calc = new ArithmeticOps();
        assertEquals(calc.divide(10, 2), 5);
    }

    @Test
    public void testDivByZero(){
        ArithmeticOps calc = new ArithmeticOps();
        expectThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}
