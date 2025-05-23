package com.pluralsight;

public class RegularTopping extends Topping {
    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    public double getPrice(SandwichSize size) {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
