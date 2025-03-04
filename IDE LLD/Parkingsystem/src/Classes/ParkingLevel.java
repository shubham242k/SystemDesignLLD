package Classes;

import ParkingSpot.*;
import Vehicles.*;
import java.util.*;
class ParkingLevel {
    SpotFindingStrategy strategy;
    int levelNumber;
    int totalSpots;
    List<Spot> spots;

    ParkingLevel(int levelNumber, int totalSpots, SpotFindingStrategy strategy) {
        this.levelNumber = levelNumber;
        this.totalSpots = totalSpots;
        this.strategy = strategy;
        initializeLevel();
    }

    void initializeLevel() {
        System.out.println("Setting Parking spots for LEVEL #:" + levelNumber);
        spots = new ArrayList<>();
        int cspot = (int) (0.5 * totalSpots);
        int bspot = (int) (0.4 * totalSpots);
        for(int i = 1; i <= cspot ; i++) {
            spots.add(new CarSpot("CAR-SPOT #" + i));
        }

        for(int i = 1; i <= bspot ; i++) {
            spots.add(new BikeSpot("BIKE-SPOT #" + i));
        }

        for(int i = 1; i <= totalSpots - (cspot + bspot) ; i++) {
            spots.add(new TruckSpot("TRUCK-SPOT #" + i));
        }
    }

    public Spot findAvailableSpot(VehicleType type) {
        return strategy.findSpot(type, spots);
    }

    public void ParkVehicle(Vehicle vehicle, Spot availableSpot) {
        availableSpot.parkVehicle(vehicle);
        System.out.println("Vehicle with license: " + vehicle.getVehicleNumber() + " is parked at Spot: " + availableSpot.getSpotNumber() + " at level: " + levelNumber);
    }

    public void unParkVehicle(Spot spot) {
        spot.vacateSpot();
        System.out.println("From LEVEL #: " + levelNumber);
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void displayAvailableSpots() {
        int cspot = 0;
        int bspot = 0;
        int tspot = 0;

        for(int i = 1 ; i <= totalSpots ; i++) {
            Spot spot = spots.get(i-1);
            if(spot.getStatus() == Status.OCCUPIED) continue;
            if(spot.getSpotType() == VehicleType.CAR) {
                cspot++;
            } else if(spot.getSpotType() == VehicleType.BIKE) {
                bspot++;
            } else {
                tspot++;
            }
        }
        System.out.println("At LEVEL: #");
        System.out.println("Available bike spots: " + bspot);
        System.out.println("Available car spots: " + cspot);
        System.out.println("Available truck spots: " + tspot);
    }
}