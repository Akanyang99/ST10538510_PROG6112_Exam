/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10538510_question.pkg1;

/**
 *
 * @author Student
 */
public class PrintProduct {

    // Prints the total product sales
    public void printTotalProductSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints the average product sales (rounded to match sample screenshot integer format)
    public void printAverageProductSales(Product product) {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    // Prints the most popular product sale
    public void printMostPopularProduct(Product product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    // Helper method to print the complete formatted report
    public void printFullReport(Product product) {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("***********************************");
        printTotalProductSales(product);
        printAverageProductSales(product);
        printMostPopularProduct(product);
    }
}