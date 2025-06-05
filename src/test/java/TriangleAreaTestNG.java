import org.example.TriangleArea;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleAreaTestNG {

    @Test
    public void testValidTriangleArea(){
        TriangleArea calc = new TriangleArea();
        double results = calc.calculateArea(3, 4,5);
        assertEquals(results, 6.0, 0.001);
    }

    @Test
    public void TestInvalidTriangleArea(){
        TriangleArea calc = new TriangleArea();
        expectThrows(IllegalArgumentException.class, () -> calc.calculateArea(1, 2, 10));
    }
}
