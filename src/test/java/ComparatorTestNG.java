import org.example.Comparator;
import org.example.FactorialOfNumber;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComparatorTestNG {
    @Test
    public void testFirst() {
        Comparator comp = new Comparator();
        assertEquals(comp.compare(10, 5), "10 больше 5");
    }

    @Test
    public void testSecond(){
        Comparator comp = new Comparator();
        assertEquals(comp.compare(4, 8), "4 меньше 8");
    }

    @Test
    public void testEqual(){
        Comparator comp = new Comparator();
        assertEquals(comp.compare(7, 7), "Числа равны");
    }
}
