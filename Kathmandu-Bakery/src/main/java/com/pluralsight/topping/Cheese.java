package com.pluralsight.topping;

public class Cheese extends Topping {
    private static final double[] prices = {.75, 1.50, 2.25};
    public Cheese(String name) { this.name = name; }
    public double getPrice(int sizeIndex) { return prices[sizeIndex]; }
}
