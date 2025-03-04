abstract class Vehicle {
	WorkShop workShop;
	Vehicle(WorkShop workShop){
		this.workShop = workShop;
	}

	public abstract void manufacture();

}

interface WorkShop {
	public void production();
}

class Car extends Vehicle {
	Car(WorkShop workShop) {
		super(workShop);
	}

	public void manufacture() {
		System.out.println("Car");
		workShop.production();
	}
}

class Bike extends Vehicle {
	Bike(WorkShop workShop) {
		super(workShop);
	}

	public void manufacture() {
		System.out.println("bike");
		workShop.production();
	}
}

class MassProduce implements WorkShop {
	public void production() {
		System.out.println("Vehicle will be producing via mass production");
	}
}

class ClassicProduce implements WorkShop {
	public void production() {
		System.out.println("Vehicle will be producing via classic production");
	}
}

public class BridgePattern {
	public static void main(String[] args) {
		WorkShop workShop = new MassProduce();
		WorkShop workShop2 = new ClassicProduce();
		Vehicle car = new Car(workShop);
		Vehicle bike = new Bike(workShop2);

		car.manufacture();
		bike.manufacture();
	}
}