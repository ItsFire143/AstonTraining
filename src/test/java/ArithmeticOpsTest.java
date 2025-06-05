import org.example.ArithmeticOps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArithmeticOpsTest {

    ArithmeticOps ops = new ArithmeticOps();

    @Test
    void testAdd(){
        assertEquals(9, ops.add(4, 5));
    }

    @Test
    void testSub(){
        assertEquals(1, ops.substract(6, 5));
    }

    @Test
    void testMulty(){
        assertEquals(20, ops.multiply(4, 5));
    }

    @Test
    void testDiv(){
        assertEquals(2.5, ops.divide(5, 2));
    }

    @Test
    void testDivZero(){
        assertNull(ops.divide(10, 0));
    }
}