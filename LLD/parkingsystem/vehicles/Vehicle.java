package parkingsystem.vehicles;

public abstract class Vehicle {
	String vehicleNumber;
	VehicleType type;
	Bill bill;

	Vehicle(String vehicleNumber, VehicleType type) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
	} 

	public VehicleType getType() {
        return type;
    }

    public String getVehicleNumber() {
    	return vehicleNumber;
    }

    public void setBill(Bill bill) {
    	this.bill = bill;
    }

    public Bill getBill() {
    	return bill;
    }
}

