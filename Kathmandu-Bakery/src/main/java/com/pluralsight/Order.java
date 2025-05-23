package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
    }

    public void addDrink(Drink d) {
        drinks.add(d);
    }

    public void addChips(Chips c) {
        chips.add(c);
    }

    public double getTotal() {
        return sandwiches.stream().mapToDouble(Sandwich::getPrice).sum()
                + drinks.stream().mapToDouble(Drink::getPrice).sum()
                + chips.size() * 1.50;
    }

    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Kathmandu-Bakery Receipt =====\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append("Date: ").append(LocalDateTime.now().format(formatter)).append("\n\n");

        int count = 1;
        for (Sandwich s : sandwiches) sb.append("Sandwich ").append(count++).append(":\n").append(s).append("\n");
        for (Drink d : drinks) sb.append("Drink: ").append(d).append("\n");
        for (Chips c : chips) sb.append("Chips: ").append(c).append("\n");

        sb.append("\nTotal: $").append(String.format("%.2f", getTotal())).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}
