package com.pluralsight.topping;

public abstract class Topping {
    protected String name;
    public String getName() { return name; }
    public abstract double getPrice(int sizeIndex);
    public String toString() { return name; }
}
