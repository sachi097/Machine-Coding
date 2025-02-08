package com.machinecoding.parkinglot.vehiclefactory;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public VehicleType getVehicleType(){
        return type;
    }
}
