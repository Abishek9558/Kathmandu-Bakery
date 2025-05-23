package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType bread;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(SandwichSize size, BreadType bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public double getPrice() {
        double basePrice = size.getBasePrice();
        double toppingCost = toppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
        return basePrice + toppingCost;
    }

    @Override
    public String toString() {
        return String.format("Size: %s\nBread: %s\nToasted: %s\nToppings: %s\nPrice: $%.2f",
                size, bread, toasted ? "Yes" : "No",
                toppings.stream().map(Object::toString).reduce("", (a, b) -> a + b + ", "),
                getPrice());
    }
}
