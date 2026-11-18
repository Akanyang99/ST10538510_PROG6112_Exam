package st10538510_question2;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculationsTest calc = new ProductCalculationsTest(3500.0);
        double expected = 525.0;
        double actual = calc.GetVat();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculationsTest calc = new ProductCalculationsTest(3500.0);
        double expected = 4200.0;
        double actual = calc.GetTotal();
        assertEquals(expected, actual, 0.01);
    }
}