package com.pluralsight;

public class Chips {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " -$1.50";
    }
}
