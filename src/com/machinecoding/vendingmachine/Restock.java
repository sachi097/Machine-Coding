package com.machinecoding.vendingmachine;

import com.machinecoding.vendingmachine.productfactory.ProductName;

import java.util.HashMap;

public class Restock {
    public HashMap<ProductName, Integer> productStockMap;
    public Restock(){

    }

    public void restockVendingMachine(int numProducts){
        int numCoke = (int) (numProducts * 0.6);
        int numLolipop = (int) (numProducts * 0.4);
        productStockMap = new HashMap<>();
        productStockMap.put(ProductName.COKE, numCoke);
        productStockMap.put(ProductName.LOLIPOP, numLolipop);
        VendingMachine.getInstance().restock(productStockMap);
    }
}
