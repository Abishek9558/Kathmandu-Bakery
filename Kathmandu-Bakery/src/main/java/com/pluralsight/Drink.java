package com.pluralsight;

public class Drink {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        return switch (size) {
            case SMALL -> 2.0;
            case MEDIUM -> 2.5;
            case LARGE -> 3.0;
        };
    }

    @Override
    public String toString() {
        return flavor + " (" + size + ") - $" + getPrice();
    }

}
