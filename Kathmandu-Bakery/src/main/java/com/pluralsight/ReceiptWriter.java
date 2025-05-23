package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveOrder(Order order) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        File folder = new File("receipts");
        if (!folder.exists()) folder.mkdir();

        File receipt = new File(folder, timestamp + ".txt");
        try (PrintWriter out = new PrintWriter(receipt)) {
            out.print(order.getReceiptText());
            System.out.println("Receipt saved to: " + receipt.getPath());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
