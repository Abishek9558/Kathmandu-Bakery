package com.pluralsight.topping;

public class RegularTopping extends Topping{ //free regualr toppings and sauce
    public RegularTopping(String name) { this.name = name; }
    public double getPrice(int sizeIndex) { return 0; }
}
