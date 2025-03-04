package ParkingSystem;
import ParkingSystem.Vehicles.Vehicle;
import ParkingSystem.VehicleType.VehicleType;


public interface SpotFindingStrategy {
	Spot findSpot(VehicleType type, List<Spot> spots);
}