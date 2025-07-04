package com.mycompany.e.commerce.system;

import java.util.*;

public class Cart {
    List<CartItem> items = new ArrayList<>(); 
    
    public void add(Product product, int quantity) {
        if (quantity <= product.quantity) {      // Check availability before adding to cart.
            items.add(new CartItem(product, quantity));
        } else {
            System.out.println("Error: Quantity exceeds stock for " + product.name);
        }
    }
    
    public boolean isEmpty() {                  // Check if the cart is empty before proceeding to checkout.
        return items.isEmpty();
    }

    public List<CartItem> getItems() {          // Return the list of items currently in the cart
        return items;
    }
}
