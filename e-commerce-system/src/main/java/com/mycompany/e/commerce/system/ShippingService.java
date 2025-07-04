package com.mycompany.e.commerce.system;

import java.util.*;
                                    // Handles shipping logic for all items that need to be delivered

public class ShippingService {
                                    // Sends a shipment notice and shows details for all shippable items

     public void ship(List<Ishippment> shippables) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
                                    // Go through each item and print its name and weight in grams

        for (Ishippment item : shippables) {
            System.out.printf("%s\t%.0fg\n", item.getName(), item.getWeight() *1000);
            totalWeight += item.getWeight();
        }
                                     // Show the total weight of the package in kilograms

        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }
}
