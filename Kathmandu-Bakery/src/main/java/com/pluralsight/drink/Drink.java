package com.pluralsight.drink;

public class Drink {
    private DrinkSize size;
    private String flavor;
    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    public double getPrice() { return size.getPrice(); }
    public String toString() {
        return size.getLabel() + " Drink (" + flavor + ") - $" + getPrice();
    }
}
