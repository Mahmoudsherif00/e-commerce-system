package com.mycompany.e.commerce.system;
import java.util.*;
public class ECommerceSystem {
       public static void main(String[] args) {
        long oneDay = 24 * 60 * 60 * 1000;
        Date freshDate = new Date(System.currentTimeMillis() + oneDay);
        Product cheese = new ShippableExpirableProduct("Cheese", 100, 5, 0.2, freshDate);
        Product tv = new ShippableProduct("TV", 200, 4, 5.0);
        Product scratchCard = new SimpleProduct("Scratch Card", 50, 10);
        Customer customer = new Customer("Mahmoud", 1000);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);
        new Checkout().process(customer, cart);
    }
}
