package ParkingSystem.ParkingSpot;
import ParkingSystem.Vehicles.VehicleType;


public class BikeSpot extends Spot {
	BikeSpot(int number) {
		super(VehicleType.BIKE, number);
	}
}
