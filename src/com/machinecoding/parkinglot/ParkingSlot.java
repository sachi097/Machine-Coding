package com.machinecoding.parkinglot;

import com.machinecoding.parkinglot.vehiclefactory.Vehicle;
import com.machinecoding.parkinglot.vehiclefactory.VehicleType;

public class ParkingSlot {
    private final int slotNumber;
    private final VehicleType slotType;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, VehicleType slotType){
        this.slotNumber = slotNumber;
        this.slotType = slotType;
    }

    public int getSlotNumber(){
        return slotNumber;
    }
    public VehicleType getSlotType(){
        return  slotType;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && getSlotType() == vehicle.getVehicleType()){
            this.vehicle = vehicle;
        }

        if(getSlotType() != vehicle.getVehicleType()){
            throw new IllegalArgumentException("Invalid vehicle park request");
        }

    }

    public synchronized void unParkVehicle(Vehicle vehicle){
        if(!isAvailable() && getSlotType() == vehicle.getVehicleType()){
            this.vehicle = null;
        }

        if(getSlotType() != vehicle.getVehicleType()){
            throw new IllegalArgumentException("Invalid vehicle unpark request");
        }

    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
