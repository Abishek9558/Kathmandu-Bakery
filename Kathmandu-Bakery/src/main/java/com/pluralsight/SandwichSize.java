package com.pluralsight;

public class SandwichSize {
    SMALL_4(5.50), MEDIUM_8(7.00), LARGE_12(8.50);

    private final double basePrice;

    SandwichSize(double price) {
        this.basePrice = price;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
