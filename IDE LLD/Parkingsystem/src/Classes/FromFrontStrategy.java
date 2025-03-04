package Classes;

import ParkingSpot.Spot;
import java.util.*;
import Vehicles.VehicleType;
import ParkingSpot.Status;
public class FromFrontStrategy implements SpotFindingStrategy {
    public Spot findSpot(VehicleType type, List<Spot> spots) {
        System.out.println("Using Classes.FromFrontStrategy");
        for(int i = 0 ; i < spots.size() ; i++) {
            Spot spot = spots.get(i);
            if(spot.getSpotType() == type) {
                if(spot.getStatus() == Status.AVAILABLE) {
                    return spot;
                }
            }
        }
        return null;
    }
}
