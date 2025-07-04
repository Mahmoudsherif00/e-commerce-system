package com.mycompany.e.commerce.system;
public class SimpleProduct extends Product {
     public SimpleProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public boolean isExpired() {
        return false;
    }
    
    public boolean needsShipping() {
        return false;
    }
}
