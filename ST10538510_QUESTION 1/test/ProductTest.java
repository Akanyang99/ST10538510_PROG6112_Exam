package st10538510_question1_pkg1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sampleSales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sampleSales);
        int expected = 153;
        int actual = product.GetTotalProductsSold();
        assertEquals(expected, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sampleSales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sampleSales);
        double expected = 17.0;
        double actual = product.GetAverageProductSold();
        assertEquals(expected, actual, 0.01);
    }
}