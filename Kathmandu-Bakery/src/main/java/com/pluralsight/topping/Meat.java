package com.pluralsight.topping;

public class Meat extends Topping{
    private static final double[] prices = {1.00, 2.00, 3.00};
    public Meat(String name) { this.name = name; }
    public double getPrice(int sizeIndex) { return prices[sizeIndex]; }
}
