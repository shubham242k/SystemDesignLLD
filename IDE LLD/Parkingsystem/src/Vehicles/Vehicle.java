package Vehicles;
import Classes.ParkingBill;

public abstract class Vehicle {
    String vehicleNumber;
    VehicleType type;
    ParkingBill bill;
    public Vehicle(String vehicleNumber, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setBill(ParkingBill bill) {
        this.bill = bill;
    }

    public ParkingBill getBill() {
        return bill;
    }
}