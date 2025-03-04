import java.util.*;
import java.io.*;

abstract class Vehicle {
  int price;
  String name;

  public Vehicle(String name) {
    this.name = name;
  }

  abstract public int getPrice(int km);

}

class Bicycle extends Vehicle {
  public Bicycle(String name){
    super(name);
  }
  public int getPrice(int km) {
    System.out.println("vehicle name " + name);
    price = 4 * km + 10;
    return price;
  }
}

class Car extends Vehicle {
  public Car(String name){
    super(name);
  }
  
  public int getPrice(int km) {
    System.out.println("vehicle name " + name);
    price = 5 * km + 50;
    return price;
  }
}

class VehicleFactory {
  Vehicle vehicle;
  public VehicleFactory(String type){
    if(type.equals("Cycle")) {
      this.vehicle = new Bicycle(type);
    } else if(type.equals("FourWheelerCar")){
      this.vehicle = new Car(type);
    }
  }

  public Vehicle getVehicle(){
    return vehicle;
  }
}

public class FactoryPattern {
  public static void main(String[] args) {
    VehicleFactory vehicleFactory = new VehicleFactory("Cycle");

    Vehicle vehicle = vehicleFactory.getVehicle();

    System.out.println(vehicle.getPrice(40));
    // System.out.println(vehicle.name);
  }
}