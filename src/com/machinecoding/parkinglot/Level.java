package com.machinecoding.parkinglot;

import com.machinecoding.parkinglot.vehiclefactory.Vehicle;
import com.machinecoding.parkinglot.vehiclefactory.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final List<ParkingSlot> slots;
    private final int floor;

    public Level(int floor, int numSpots){
        this.floor = floor;
        slots = new ArrayList<>();

        int numMotorCycles = (int) (numSpots * 0.3);
        int numCars = (int) (numSpots * 0.5);
        int numTrucks = (int) (numSpots * 0.2);
        int slotNum = 1;

        for(int i=0; i<numMotorCycles; i++){
            slots.add(new ParkingSlot(slotNum, VehicleType.MOTORCYCLE));
            slotNum++;
        }

        for(int i=0; i<numCars; i++){
            slots.add(new ParkingSlot(slotNum, VehicleType.CAR));
            slotNum++;
        }

        for(int i=0; i<numTrucks+1; i++){
            slots.add(new ParkingSlot(slotNum, VehicleType.TRUCK));
            slotNum++;
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSlot slot: slots){
            Vehicle parkedVehicle = slot.getVehicle();
            if(parkedVehicle != null && parkedVehicle.equals(vehicle)){
                throw new IllegalCallerException("Vehicle : " + vehicle.getLicensePlate() + " is already parked");
            }
            if(slot.isAvailable() && slot.getSlotType() == vehicle.getVehicleType()){
                try {
                    slot.parkVehicle(vehicle);
                    return true;
                }
                catch (IllegalArgumentException exception){
                    return false;
                }
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSlot slot: slots){
            if(!slot.isAvailable() && slot.getSlotType() == vehicle.getVehicleType() && slot.getVehicle().equals(vehicle)){
                try {
                    slot.unParkVehicle(vehicle);
                    return true;
                }
                catch (IllegalArgumentException exception){
                    return false;
                }
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level: " + floor + " Availability Status");
        for(ParkingSlot slot: slots){
            System.out.println("Slot: " + slot.getSlotNumber() + (slot.isAvailable() ? " is Available for " : " is Occupied by " + slot.getVehicle().getLicensePlate() + " ") + slot.getSlotType());
        }
    }


}
