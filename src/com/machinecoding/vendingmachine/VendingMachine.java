package com.machinecoding.vendingmachine;

import com.machinecoding.vendingmachine.moneyFactory.Denomination;
import com.machinecoding.vendingmachine.moneyFactory.Money;
import com.machinecoding.vendingmachine.productfactory.Product;
import com.machinecoding.vendingmachine.productfactory.ProductName;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VendingMachine {
    private static volatile VendingMachine machine;

    private List<Product> productList;

    private VendingMachine(){
        productList = Collections.synchronizedList(new ArrayList<>());
    }

    public static VendingMachine getInstance(){
        VendingMachine result = machine;
        if(result == null){
            synchronized (VendingMachine.class){
                result = machine;
                if(result == null){
                    result = machine = new VendingMachine();
                }
            }
        }
        return  result;
    }

    public void restock(HashMap<ProductName, Integer> productStock){
        for(int i=0; i<productList.size(); i++){
            Product product = productList.get(i);
            if(productStock.containsKey(product.getProductName())){
                product.setStock(productStock.get(product.getProductName()));
                productList.set(i, product);
            }
        }
    }

    public void displayStock(){
        for (Product product : productList) {
            System.out.println(product.getProductName() + " : " + product.getStock());
        }
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Money> vendProduct(ProductName productToBuy, List<Money> moneyList){
        double currentAmount = 0.0;
        for(Money money: moneyList){
            currentAmount += money.getValue();
        }
        System.out.println("Requested product " + productToBuy);
        for(Product product: productList){
            if(product.getProductName().equals(productToBuy)){
                if(checkMoney(currentAmount, product)){
                    try{
                        product.vendProduct();
                        System.out.println("Vended product " + product.getProductName() + " for " + product.getProductPrice());
                        return returnChange(currentAmount = currentAmount - product.getProductPrice(), moneyList);
                    }
                    catch (InsufficientResourcesException exception){
                        System.out.println(exception.getMessage());
                        return moneyList;
                    }
                }
                else{
                    System.out.println("Insufficient Funds Sorry");
                }
            }
        }
        return moneyList;
    }

    private List<Money> returnChange(double currentAmount, List<Money> moneyList){
        double note = (int) (currentAmount / 10) * 10;
        double coin = currentAmount % 10;
        for(int i=0; i<moneyList.size(); i++){
            Money money = moneyList.get(i);
            if(money.getType() == Denomination.NOTE){
                money.setValue(note);
                moneyList.set(i, money);
            }
            else{
                money.setValue(coin);
                moneyList.set(i, money);
            }
        }
        return moneyList;
    }

    private boolean checkMoney(double currentAmount, Product product){
        return currentAmount >= product.getProductPrice();
    }


}
