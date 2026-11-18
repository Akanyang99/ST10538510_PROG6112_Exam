/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10538510_question2;

/**
 *
 * @author Student
 */
package st10538510_question2;

public class ProductCalculationsTest implements IProductCalculations {

    private double price;

    // Constructor accepting the product price
    public ProductCalculationsTest(double price) {
        this.price = price;
    }

    // Calculates 15% VAT
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Calculates 5% Commission
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Calculates Total Sale Amount: Price + VAT + Commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}