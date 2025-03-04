package ParkingSystem;
import ParkingSystem.Vehicles.Vehicle;
import ParkingSystem.VehicleType.VehicleType;
import ParkingSystem.ParkingSpot.Spot;
import ParkingSystem.ParkingSpot.Status;


public class FromFrontStrategy implements SpotFindingStrategy {
	public Spot findSpot(VehicleType type, List<Spot> spots) {
		System.out.println("Using FromFrontStrategy");
		for(int i = 0 ; i < spots.size() ; i++) {
			Spot spot = spots.get(i);
			if(spots.getSpotType == type) {
				if(spot.getStatus == Status.AVAILABLE) {
					return spot;
				}
			}
		}
	}
}