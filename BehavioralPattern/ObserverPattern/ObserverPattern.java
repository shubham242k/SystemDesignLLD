import java.util.*;
class Order {
	int id;
	String status;
	List<Observer> observers;

	Order(int id) {
		this.id = id;
		this.status = "PREPARING";
		observers = new ArrayList<>();
	}

	public void addOberserver(Observer observer) {
		observers.add(observer);
	}

	public void removeOberserver(Observer observer) {
		observers.remove(observer);
	}

	public void changeStatus(String status) {
		this.status = status;
		notifyObs();
	}

	private void notifyObs(){
		for (Observer obs : observers) {
			obs.update(this);
		}
	}

}

interface Observer {
	void update(Order order);
}

class User implements Observer {
	String name;
	User(String name) {
		this.name = name;
	}
	public void update(Order order) {
		System.out.println("User: "+ name + " order id and status: " + order.id + " " + order.status);
	}
}
class Res implements Observer {
	String name;
	Res(String name) {
		this.name = name;
	}
	public void update(Order order) {
		System.out.println("Restaurant: "+ name + " order id and status: " + order.id + " " + order.status);
	}
}
public class ObserverPattern {
	public static void main(String[] args) {
		Observer user = new User("Shubham");
		Observer res = new Res("Chinese Delight");

		Order order = new Order(1);
		order.addOberserver(user);
		order.changeStatus("PACKING");

		order.addOberserver(res);
		order.changeStatus("DELIVERING");
	}
}