package Classes;

import ParkingSpot.Spot;
import ParkingSpot.Status;
import java.util.*;
import Vehicles.VehicleType;


public class FromBackStrategy implements SpotFindingStrategy {
    public Spot findSpot(VehicleType type, List<Spot> spots) {
        System.out.println("Using FromBacktStrategy");
        for(int i = spots.size() - 1  ; i >= 0 ; i--) {
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
