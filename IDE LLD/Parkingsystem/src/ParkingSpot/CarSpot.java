package ParkingSpot;
import Vehicles.VehicleType;
public class CarSpot extends Spot {
    public CarSpot(String number) {
        super(VehicleType.CAR, number);
    }
}
