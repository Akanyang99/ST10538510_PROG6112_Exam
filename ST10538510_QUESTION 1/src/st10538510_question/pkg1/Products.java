/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10538510_question.pkg1;

/**
 *
 * @author Student
 */
public class Products {
public class Product implements IProduct {

    private String[] products;
    private int[][] sales;

    // Constructor accepting the 1D product names array and 2D sales array
    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }

    // Calculates the total number of products sold across all products and months
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                total += sales[row][col];
            }
        }
        return total;
    }

    // Calculates the average number of products sold across all entries
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int row = 0; row < sales.length; row++) {
            count += sales[row].length;
        }
        return (double) total / count;
    }

    // Finds the product with the highest single monthly sale and formats it as "Product Name(maxSale)"
    // Matches Sample Screenshot: "Cozy Nights Monarch(25)"
    @Override
    public String GetMostPopularProduct() {
        int maxSale = sales[0][0];
        int topProductIndex = 0;

        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                if (sales[row][col] > maxSale) {
                    maxSale = sales[row][col];
                    topProductIndex = row;
                }
            }
        }
        return products[topProductIndex] + "(" + maxSale + ")";
    }
}