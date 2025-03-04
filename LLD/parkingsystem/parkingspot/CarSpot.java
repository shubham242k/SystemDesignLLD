package ParkingSystem.ParkingSpot;
import ParkingSystem.Vehicles.VehicleType;


public class CarSpot extends Spot {
	CarSpot(int number) {
		super(VehicleType.CAR, number);
	}
}