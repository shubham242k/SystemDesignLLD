package ParkingSpot;
import Vehicles.VehicleType;

public class TruckSpot extends Spot {
    public TruckSpot(String number) {
        super(VehicleType.TRUCK, number);
    }
}
