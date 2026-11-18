package st10538510_question2;

public class ProductCalculations implements IProductCalculations {

    private double price;

    // Constructor accepting the product price
    public ProductCalculations(double price) {
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
