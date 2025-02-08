package com.machinecoding.vendingmachine.moneyFactory;

public class Money {
    private Denomination type;
    private double value;

    public Money(Denomination type, double value){
        this.type = type;
        this.value = value;
    }

    public Denomination getType(){
        return type;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }
}
