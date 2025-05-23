package com.pluralsight;

public abstract class Topping {
    public abstract double getPrice(SandwichSize size);

    public interface Topping {
        double getPrice(SandwichSize size);
        String toString();
    }
}
