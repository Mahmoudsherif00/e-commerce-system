package com.mycompany.e.commerce.system;

import java.util.*;

public class Checkout {

    public void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        } 
        
        double subtotal = 0;
        List<Ishippment> shippables = new ArrayList<>();
        
        for (CartItem item : cart.getItems()) {                      // Check if the product is expired before proceeding.
            if (item.product.isExpired()) {                    
                System.out.println("Error: " + item.product.name + " is expired.");
                return;
            }
            if (item.quantity > item.product.quantity) {            // Check availability before proceeding.
                System.out.println("Error: Not enough stock for " + item.product.name);
                return; 
            }
            subtotal += item.totalPrice();

            if (item.product instanceof Ishippment) {                // Add product to the list of shippable items if it requires shipping.
                shippables.add((Ishippment) item.product);
            }
        }

        double shipping = shippables.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {                           // Check if the customer has enough balance to complete proceeding.
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.pay(total);                                        // Give pay function the total price to subtract it from customer's balance

        for (CartItem item : cart.getItems()) {                     // Update product stock: subtract the bought quantity from what's available
            item.product.quantity -= item.quantity;
        }

        if (!shippables.isEmpty()) {                                // If there are items that need shipping, send them using the shipping service

            new ShippingService().ship(shippables);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.name, item.totalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Remaining Balance: %.0f\n", customer.balance);
    }
}
