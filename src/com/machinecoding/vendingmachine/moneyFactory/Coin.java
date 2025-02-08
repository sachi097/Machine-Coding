package com.machinecoding.vendingmachine.moneyFactory;

public class Coin extends Money{
    public Coin(double value){
        super(Denomination.COIN, value);
    }
}
