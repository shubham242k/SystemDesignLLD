package Classes;

import ParkingSpot.Spot;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class ParkingManager {
    private static ParkingManager instance;
    private List<ParkingLevel> levels;
    private ParkingManager(){
        levels = new ArrayList<>();
    }

    public static ParkingManager getInstance() {
        if(instance == null){
            instance = new ParkingManager();
        }
        return instance;
    }

    public void initializeParkingManager(int totalLevel) {
        System.out.println("Setting Parking System with total level: " + totalLevel);
        for(int i = 0 ; i < totalLevel ; i++) {
            ParkingLevel level;
            if(i % 2 == 0) {
                level = new ParkingLevel((i + 1), 5, new FromFrontStrategy());
            } else {
                level = new ParkingLevel((i + 1), 5, new FromBackStrategy());
            }
            levels.add(level);
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        boolean parked = false;
        for(ParkingLevel level : levels) {
            level.displayAvailableSpots();
            Spot spot = level.findAvailableSpot(vehicle.getType());
            if(spot != null) {
                level.ParkVehicle(vehicle, spot);
                vehicle.setBill(new ParkingBill(spot, level));
                parked = true;
                break;
            }
        }
        if(parked == false) {
            System.out.println("Spot not available for vehicle with license: " + vehicle.getVehicleNumber());
        }
    }

    public void unParkVehicle(Vehicle vehicle, int dur) {
        ParkingBill bill = vehicle.getBill();
        Spot spot = bill.getSpot();
        ParkingLevel level = bill.getLevel();
        level.unParkVehicle(spot);
        bill.payAmount(dur);
    }

}