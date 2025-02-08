package com.machinecoding.vendingmachine.moneyFactory;

public class Note extends Money{
    public Note(double value){
        super(Denomination.NOTE, value);
    }
}
