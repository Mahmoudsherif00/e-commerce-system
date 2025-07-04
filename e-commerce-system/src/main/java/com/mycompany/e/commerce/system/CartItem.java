package com.mycompany.e.commerce.system;
public class CartItem {
    Product product;
    int quantity;
    
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double totalPrice() {                     // Calculate the total price for this cart item
        return quantity * product.price; 
    }
}
