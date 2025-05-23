package com.pluralsight;

public class Meat extends Topping {
    private String type;
    private boolean extra;

    public Meat(String type, boolean extra) {
        this.type = type;
        this.extra = extra;
    }
    @Override
    public double getPrice(SandwichSize size) {
        double[] prices = {1.0, 2.0, 3.0};
        double[] extras = {0.5, 1.0, 1.5};
        int index = size.ordinal();
        return extra ? extras[index] : prices[index];
    }

    @Override
    public String toString() {
        return (extra ? "Extra " : "") + type;

    }
}
