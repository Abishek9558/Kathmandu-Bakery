package com.pluralsight;

public class Cheese extends Topping {
    private String type;
    private boolean extra;

    public Cheese(String type, boolean extra) {
        this.type = type;
        this.extra = extra;
    }
    @Override
    public double getPrice(SandwichSize size) {
        double[] prices = {0.75, 1.5, 2.25};
        double[] extras = {0.3, 0.6, 0.9};
        int index = size.ordinal();
        return extra ? extras[index] : prices[index];
    }

    @Override
    public String toString() {
        return (extra ? "Extra " : "") + type;

    }
}
