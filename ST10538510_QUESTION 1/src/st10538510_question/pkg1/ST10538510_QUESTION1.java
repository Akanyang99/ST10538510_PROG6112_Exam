package st10538510_question.pkg1;

public class ST10538510_QUESTION1 {

    public static void main(String[] args) {
        // 1D array - product names
        String[] products = {"Cozy Nights Monarch", "Elegant Lace Curtain", "Velvet Dream Duvet"};

        // 2D array - sales [product][month]
        int[][] sales = {
            {12, 18, 25},
            {10, 15, 20},
            {8, 14, 19}
        };

        // Create Products object
        Products prod = new Products(products, sales);

        // Call methods and display results
        System.out.println("Total Products Sold: " + prod.GetTotalProductsSold());
        System.out.println("Average Products Sold: " + prod.GetAverageProductSold());
        System.out.println("Most Popular Product: " + prod.GetMostPopularProduct());
    }
}
