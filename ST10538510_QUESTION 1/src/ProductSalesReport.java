package st10538510_question1_pkg1;

import java.util.Scanner;

public class ST10538510_QUESTION1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Single-dimensional array for the 3 mattress products
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array for 3 products x 3 months
        int[][] sales = new int[3][3];

        // Prompt user for monthly sales for each mattress
        for (int row = 0; row < products.length; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("Enter number of sales for month " + (col + 1)
                        + " for " + products[row] + " mattress: ");
                sales[row][col] = scanner.nextInt();
            }
            System.out.println(); // Blank line between products matching sample screenshot
        }

        // Create Product and PrintProduct objects and display the report
        Product productLogic = new Product(products, sales);
        PrintProduct printer = new PrintProduct();
        printer.printFullReport(productLogic);

        scanner.close();
    }
}/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class ProductSalesReport {
    
}
