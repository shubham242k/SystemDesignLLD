package ParkingSpot;
import Vehicles.Vehicle;
import Vehicles.VehicleType;

public class Spot {
    private VehicleType type;
    String spotNumber;
    Status status;
    Vehicle parkedVehicle;
    int startTime;
    Spot(VehicleType type, String spotNumber) {
        this.type = type;
        this.spotNumber = spotNumber;
        this.status = Status.AVAILABLE;
        parkedVehicle = null;
    }

    public VehicleType getSpotType() {
        return type;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        if(status == Status.OCCUPIED) {
            return parkedVehicle;
        } else {
            System.out.println("Spot with spot no.: " + spotNumber + " is not occupied");
            return null;
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        status = Status.OCCUPIED;
    }

    public void vacateSpot() {
        this.parkedVehicle = null;
        status = Status.AVAILABLE;
        System.out.println("SPOT: " + spotNumber + " vacated");
    }

    public Status getStatus() {
        return status;
    }
}
