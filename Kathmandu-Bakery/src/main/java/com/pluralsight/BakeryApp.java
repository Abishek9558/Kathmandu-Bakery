package com.pluralsight;

import com.pluralsight.bread.*;
import com.pluralsight.drink.*;
import com.pluralsight.food.Sandwich;
import com.pluralsight.order.Order;
import com.pluralsight.size.LargeSize;
import com.pluralsight.size.MediumSize;
import com.pluralsight.size.SandwichSize;
import com.pluralsight.size.SmallSize;
import com.pluralsight.snack.Chips;
import com.pluralsight.topping.Cheese;
import com.pluralsight.topping.Meat;
import com.pluralsight.topping.RegularTopping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BakeryApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Kathmandu-Bakery\n1) New Order\n0) Exit");
            int choice = sc.nextInt();
            if (choice == 0) break;
            if (choice == 1) handleOrder();
        }
    }

    static void handleOrder() { // users build and checkout the order
        Order order = new Order();
        while (true) {
            System.out.println("1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n0) Cancel Order");
            int option = sc.nextInt(); sc.nextLine();
            switch (option) {
                case 0: return;
                case 1: order.addSandwich(createSandwich()); break;
                case 2: order.addDrink(createDrink()); break;
                case 3: order.addChips(new Chips(prompt("Enter chip type:"))); break;
                case 4:
                    System.out.println(order.getDetails());
                    saveReceipt(order);
                    return;
            }
        }
    }

    static Sandwich createSandwich() { //builds sandwich from user choices
        SandwichSize size = switch (prompt("Size (4/8/12):")) {
            case "4" -> new SmallSize();
            case "8" -> new MediumSize();
            default -> new LargeSize();
        };
        Bread bread = switch (prompt("Bread (white/wheat/rye/wrap):")) {
            case "white" -> new WhiteBread();
            case "wheat" -> new WheatBread();
            case "rye" -> new RyeBread();
            default -> new WrapBread();
        };
        boolean toasted = prompt("Toasted? (yes/no):").equalsIgnoreCase("yes");
        Sandwich sandwich = new Sandwich(size, bread, toasted);

        while (true) {
            System.out.println("Select topping type: 1) Meat 2) Cheese 3) Regular 0) Done");
            String toppingType = sc.nextLine();
            if (toppingType.equals("0")) break;

            List<String> options = new ArrayList<>();
            if (toppingType.equals("1")) {
                options = List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
            } else if (toppingType.equals("2")) {
                options = List.of("American", "Provolone", "Cheddar", "Swiss");
            } else if (toppingType.equals("3")) {
                options = List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
                        "Cucumbers", "Pickles", "Guacamole", "Mushrooms",
                        "Mayo", "Mustard", "Ketchup", "Ranch",
                        "Thousand Islands", "Vinaigrette", "Au Jus", "Sauce");
            } else {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            for (int i = 0; i < options.size(); i++)
                System.out.println((i + 1) + ") " + options.get(i));
            System.out.print("Choose topping number: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice < 1 || choice > options.size()) {
                System.out.println("Invalid choice.");
                continue;
            }
            String name = options.get(choice - 1);
            switch (toppingType) {
                case "1" -> sandwich.addTopping(new Meat(name));
                case "2" -> sandwich.addTopping(new Cheese(name));
                case "3" -> sandwich.addTopping(new RegularTopping(name));
            }
            System.out.println(name + " added.");
        }
        return sandwich;
    }

    static Drink createDrink() {
        DrinkSize size = switch (prompt("Drink size (s/m/l):")) {
            case "s" -> new SmallDrink();
            case "m" -> new MediumDrink();
            default -> new LargeDrink();
        };
        String flavor = prompt("Flavor:");
        return new Drink(size, flavor);
    }
/*method for timestamp filename and saving the receipts */
    static void saveReceipt(Order order) {
        String fileName = String.format("src/main/resources/receiptssaver/receipt-%tF-%<tH%<tM%<tS.txt", new Date());
        try (FileWriter fw = new FileWriter(fileName); PrintWriter out = new PrintWriter(fw)) {
            out.println(order.getDetails());
            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }

    static String prompt(String msg) {
        System.out.print(msg + " ");
        return sc.nextLine();
    }
}
