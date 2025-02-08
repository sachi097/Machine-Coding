package com.machinecoding.vendingmachine;

import com.machinecoding.vendingmachine.moneyFactory.Coin;
import com.machinecoding.vendingmachine.moneyFactory.Money;
import com.machinecoding.vendingmachine.moneyFactory.Note;
import com.machinecoding.vendingmachine.productfactory.Coke;
import com.machinecoding.vendingmachine.productfactory.Lolipop;
import com.machinecoding.vendingmachine.productfactory.Product;
import com.machinecoding.vendingmachine.productfactory.ProductName;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineManager {
    public static void main(String[] args){
        VendingMachine machine = VendingMachine.getInstance();
        Restock restock = new Restock();

        Product coke = new Coke(1, 1, 15);
        Product lolipop = new Lolipop(2, 1, 5);

        machine.addProduct(coke);
        machine.addProduct(lolipop);

        machine.displayStock();

        Money note = new Note(10);
        Money coin = new Coin(10);

        List<Money> moneyList = new ArrayList<>();
        moneyList.add(note);
        moneyList.add(coin);

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }


        moneyList = machine.vendProduct(ProductName.COKE, moneyList);

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }

        moneyList = machine.vendProduct(ProductName.LOLIPOP, moneyList);

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }

        moneyList.get(0).setValue(30);

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }

        moneyList = machine.vendProduct(ProductName.COKE, moneyList);

        restock.restockVendingMachine(10);
        restock.restockVendingMachine(10);

        machine.displayStock();

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }

        moneyList = machine.vendProduct(ProductName.COKE, moneyList);

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }

        moneyList = machine.vendProduct(ProductName.LOLIPOP, moneyList);

        for(Money money: moneyList){
            System.out.println(money.getType() + " " + money.getValue());
        }

        machine.displayStock();

        moneyList = machine.vendProduct(ProductName.COKE, moneyList);
    }
}
