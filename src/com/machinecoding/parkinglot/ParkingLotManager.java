package com.machinecoding.parkinglot;

import com.machinecoding.parkinglot.vehiclefactory.*;

public class ParkingLotManager {
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addLevel(new Level(1, 5));


        Vehicle motorCycle = new Motorcycle("ABC123", VehicleType.MOTORCYCLE);
        Vehicle motorCycle2 = new Motorcycle("AUC123", VehicleType.MOTORCYCLE);
        Vehicle car = new Car("MCQ123", VehicleType.CAR);
        Vehicle truck = new Truck("XYZ123", VehicleType.TRUCK);

        parkingLot.parkVehicle(motorCycle);
        parkingLot.parkVehicle(motorCycle);
        parkingLot.parkVehicle(motorCycle);
        parkingLot.parkVehicle(motorCycle2);





        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        System.out.println();
        parkingLot.displayAvailability();
        System.out.println();
        parkingLot.unParkVehicle(motorCycle);
        System.out.println();

        parkingLot.displayAvailability();

    }
}
