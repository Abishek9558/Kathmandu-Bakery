package com.pluralsight.order;

import com.pluralsight.drink.Drink;
import com.pluralsight.food.Sandwich;
import com.pluralsight.snack.Chips;

import java.util.ArrayList;
import java.util.List;

public class Order { // customers full order with all food and drinks
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich s) { sandwiches.add(s); }
    public void addDrink(Drink d) { drinks.add(d); }
    public void addChips(Chips c) { chips.add(c); }
    public double getTotal() {
        return sandwiches.stream().mapToDouble(Sandwich::getPrice).sum() +
                drinks.stream().mapToDouble(Drink::getPrice).sum() +
                chips.stream().mapToDouble(Chips::getPrice).sum();
    }
    public String getDetails() { //prints aall items and total
        StringBuilder sb = new StringBuilder("Order Details:\n");
        for (Sandwich s : sandwiches) sb.append(s).append("\n");
        for (Drink d : drinks) sb.append(d).append("\n");
        for (Chips c : chips) sb.append(c).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        return sb.toString();
    }
}
