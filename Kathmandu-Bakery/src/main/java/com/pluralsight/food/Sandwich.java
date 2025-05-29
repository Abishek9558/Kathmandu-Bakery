package com.pluralsight.food;

import com.pluralsight.bread.Bread;
import com.pluralsight.size.SandwichSize;
import com.pluralsight.topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich { //sandwich made with bread toppings and toast option
    private SandwichSize size;
    private Bread bread;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(SandwichSize size, Bread bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }
    public void addTopping(Topping topping) { toppings.add(topping); }
    public double getPrice() {
        double total = size.getBasePrice();
        for (Topping t : toppings) total += t.getPrice(size.getIndex());
        return total;
    }
    public String toString() {
        return size.getLabel() + " Sandwich on " + bread.getName() + (toasted ? " (Toasted)" : "") +
                ", Toppings: " + toppings + " - $" + String.format("%.2f", getPrice());
    }
}
