package com.mycompany.e.commerce.system;

import java.util.*;

class ExpirableProduct extends Product {
    Date expiryDate;

    public ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
         long currentTime = System.currentTimeMillis();
         long expiryTime = expiryDate.getTime();
         return currentTime > expiryTime;

    }
   
    public boolean needsShipping() {
        return false;
    }
}
