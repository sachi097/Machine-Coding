package com.machinecoding.parkinglot;

import com.machinecoding.parkinglot.Level;
import com.machinecoding.parkinglot.ParkingSlot;
import com.machinecoding.parkinglot.vehiclefactory.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Level> levels;
    private static volatile ParkingLot instance;

    private ParkingLot(){
        levels = new ArrayList<>();
    }

    public static ParkingLot getInstance(){
        ParkingLot result = instance;
        if(result == null){
            synchronized (ParkingLot.class){
                result = instance;
                if(result == null){
                    result = instance = new ParkingLot();
                }
            }
        }

        return result;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public void parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            try {
                if (level.parkVehicle(vehicle)) {
                    System.out.println(vehicle.getVehicleType() + " Parked");
                    return;
                }
            }
            catch (IllegalCallerException exception){
                System.out.println(exception.getMessage());
                return;
            }
        }
        System.out.println("Sorry no parking slot available for " + vehicle.getVehicleType());
    }

    public void unParkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.unParkVehicle(vehicle)){
                System.out.println(vehicle.getVehicleType() + " Unparked");
                return;
            }
        }
        System.out.println("Sorry " + vehicle.getVehicleType() + " does not exist");
    }

    public void displayAvailability(){
        for(Level level: levels){
            level.displayAvailability();
        }
    }
}
