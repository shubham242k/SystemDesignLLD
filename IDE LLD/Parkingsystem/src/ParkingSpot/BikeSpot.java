package ParkingSpot;
import Vehicles.VehicleType;

public class BikeSpot extends Spot {
    public BikeSpot(String number) {
        super(VehicleType.BIKE, number);
    }
}