import Vehicles.*;
import ParkingSpot.*;

public class ParkingSystem {
    public static void main(String[] args) {
        Classes.ParkingManager manager = Classes.ParkingManager.getInstance();
        manager.initializeParkingManager(2);
        Vehicle car1 = new Car("DL021");
        Vehicle car2 = new Car("DL022");
        Vehicle car3 = new Car("DL023");
        Vehicle car4 = new Car("DL024");
        Vehicle car5 = new Car("DL025");

        Vehicle bike1 = new Bike("BK021");
        Vehicle bike2 = new Bike("BK022");
        Vehicle bike3 = new Bike("BK023");
        Vehicle bike4 = new Bike("BK024");
        Vehicle bike5 = new Bike("BK025");

        Vehicle truck1 = new Truck("TK021");
        Vehicle truck2 = new Truck("TK022");
        Vehicle truck3 = new Truck("TK023");
        Vehicle truck4 = new Truck("TK024");
        Vehicle truck5 = new Truck("TK025");

        manager.parkVehicle(car1);
        manager.parkVehicle(car2);
        manager.parkVehicle(truck1);
        manager.unParkVehicle(truck1, 1);

    }
}