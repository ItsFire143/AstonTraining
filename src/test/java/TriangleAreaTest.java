
import org.example.TriangleArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

    public class TriangleAreaTest {

        @Test
        void validTriangleArea(){
            TriangleArea calc = new TriangleArea();
            double area = calc.calculateArea(3, 4, 5);
            assertEquals(6.0, area, 0.0001);
        }

        @Test
        void invalidTriangleShouldThrowException() {
            TriangleArea calc = new TriangleArea();
            assertThrows(IllegalArgumentException.class, () -> {
                calc.calculateArea(1, 2, 10);
            });
        }
    }
