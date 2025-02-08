package com.machinecoding.vendingmachine.productfactory;

public class Coke extends Product {
    public Coke(int productId, int stock, double productPrice){
        super(productId, ProductName.COKE,stock, productPrice);
    }
}
