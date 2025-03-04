package ParkingSystem.ParkingSpot;
import ParkingSystem.Vehicles.VehicleType;

public class TruckSpot extends Spot {
	TruckSpot(int number) {
		super(VehicleType.TRUCK, number);
	}
}