package Classes;

import ParkingSpot.Spot;
import Vehicles.VehicleType;
import java.util.*;

public interface SpotFindingStrategy {
    Spot findSpot(VehicleType type, List<Spot> spots);
}