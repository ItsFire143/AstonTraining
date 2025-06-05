import org.example.Comparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {
    Comparator comparator = new Comparator();

    @Test
    void testFirst() {
        assertEquals("10 больше 5", comparator.compare(10, 5));
    }

    @Test
    void testSecond() {
        assertEquals("5 меньше 10", comparator.compare(5, 10));
    }

    @Test
    void testThird() {
        assertEquals("Числа равны", comparator.compare(5, 5));
    }
}