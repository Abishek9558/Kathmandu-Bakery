package com.pluralsight;

import java.util.Scanner;

public class BakeryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Welcome to Kathmandu-Bakery =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> handleNewOrder(scanner);
                case "0" -> {
                    System.out.println("Thank you for visiting Kathmandu-Bakery!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void handleNewOrder(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- New Order ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> order.addSandwich(buildSandwich(scanner));
                case "2" -> order.addDrink(buildDrink(scanner));
                case "3" -> order.addChips(buildChips(scanner));
                case "4" -> {
                    System.out.println("\n" + order);
                    System.out.print("Confirm order? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        ReceiptWriter.saveOrder(order);
                        System.out.println("Order saved. Returning to main menu.");
                    }
                    ordering = false;
                }
                case "0" -> {
                    System.out.println("Order canceled. Returning to main menu.");
                    ordering = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static Sandwich buildSandwich(Scanner scanner) {
        System.out.println("\nChoose Bread Type:");
        for (BreadType b : BreadType.values()) {
            System.out.println(b.ordinal() + 1 + ") " + b);
        }
        BreadType bread = BreadType.values()[Integer.parseInt(scanner.nextLine()) - 1];

        System.out.println("Choose Sandwich Size:\n1) 4\"\n2) 8\"\n3) 12\"");
        SandwichSize size = switch (scanner.nextLine()) {
            case "1" -> SandwichSize.SMALL_4;
            case "2" -> SandwichSize.MEDIUM_8;
            case "3" -> SandwichSize.LARGE_12;
            default -> throw new IllegalArgumentException("Invalid size");
        };

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.println("Add meats (comma-separated, e.g. steak,ham):");
        for (String meat : scanner.nextLine().split(",")) {
            if (!meat.isBlank()) sandwich.addTopping(new Meat(meat.trim(), false));
        }

        System.out.println("Add extra meats (comma-separated):");
        for (String meat : scanner.nextLine().split(",")) {
            if (!meat.isBlank()) sandwich.addTopping(new Meat(meat.trim(), true));
        }

        System.out.println("Add cheeses (comma-separated):");
        for (String cheese : scanner.nextLine().split(",")) {
            if (!cheese.isBlank()) sandwich.addTopping(new Cheese(cheese.trim(), false));
        }

        System.out.println("Add extra cheeses (comma-separated):");
        for (String cheese : scanner.nextLine().split(",")) {
            if (!cheese.isBlank()) sandwich.addTopping(new Cheese(cheese.trim(), true));
        }

        System.out.println("Add regular toppings (comma-separated):");
        for (String topping : scanner.nextLine().split(",")) {
            if (!topping.isBlank()) sandwich.addTopping(new RegularTopping(topping.trim()));
        }

        return sandwich;
    }

    private static Drink buildDrink(Scanner scanner) {
        System.out.println("\nChoose Drink Size:\n1) Small\n2) Medium\n3) Large");
        DrinkSize size = switch (scanner.nextLine()) {
            case "1" -> DrinkSize.SMALL;
            case "2" -> DrinkSize.MEDIUM;
            case "3" -> DrinkSize.LARGE;
            default -> throw new IllegalArgumentException("Invalid drink size");
        };

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }

    private static Chips buildChips(Scanner scanner) {
        System.out.print("\nEnter chip type: ");
        return new Chips(scanner.nextLine());
    }
}
