package com.pluralsight.snack;

public class Chips { //chips snack for a fixed price
    private String type;
    public Chips(String type) { this.type = type; }
    public double getPrice() { return 1.50; }
    public String toString() { return "Chips (" + type + ") - $1.50"; }
}
