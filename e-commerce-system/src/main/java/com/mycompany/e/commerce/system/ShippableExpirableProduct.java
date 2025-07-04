package com.mycompany.e.commerce.system;

import java.util.Date;
// like Cheese case 
public class ShippableExpirableProduct extends ShippableProduct {

   Date expiryDate;

    public ShippableExpirableProduct(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }
    
    public boolean isExpired() {                        // Checks if the date has already passed — returns true if it's expired, false if it's still valid.
     long currentTime = System.currentTimeMillis();
     long expiryTime = expiryDate.getTime();
     return currentTime > expiryTime;

    }

    public boolean needsShipping() {                   // Since this is a real, physical item, it needs to be shipped to the buyer
        return true;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
