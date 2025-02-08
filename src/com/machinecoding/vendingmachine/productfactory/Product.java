package com.machinecoding.vendingmachine.productfactory;

import javax.naming.InsufficientResourcesException;

public class Product {
    private final int productId;
    private final ProductName productName;

    private final double productPrice;

    private int stock;

    public Product(int productId, ProductName productName, int stock, double productPrice){
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.productPrice = productPrice;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock += stock;
    }

    public int getProductId(){
        return productId;
    }

    public double getProductPrice(){
        return productPrice;
    }

    public  ProductName getProductName(){
        return productName;
    }

    public boolean isProductAvailable(){
        return stock > 0;
    }

    public synchronized void vendProduct() throws InsufficientResourcesException {
        if(isProductAvailable()){
            stock = stock - 1;
        }
        else{
            throw new InsufficientResourcesException("Product out of stock");
        }
    }

}
