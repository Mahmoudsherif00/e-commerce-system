package com.mycompany.e.commerce.system;
// Like Tv Case 
public class ShippableProduct extends Product implements Ishippment {
      double weight;
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    public boolean isExpired() {
        return false;                     // we don’t need expired products
    }
    public boolean needsShipping() {
        return true;                     // Shipping is required because the product is delivered
    }
    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
