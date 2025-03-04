abstract class Traveller {
	String name;
	RouteStrategy strategy;
	Traveller(String name, RouteStrategy strategy){
		this.name = name;
		this.strategy = strategy;
	}
	abstract public void findRoute();
}

class Cyclist extends Traveller {
	Cyclist(String name, RouteStrategy strategy) {
		super(name, strategy);
	}
	public void findRoute() {
		strategy.route(name);
	}
}

class Walker extends Traveller {
	Walker(String name, RouteStrategy strategy) {
		super(name, strategy);
	}
	public void findRoute() {
		strategy.route(name);
	}
}

interface RouteStrategy {
	void route(String name);
}

class WalkingRoute implements RouteStrategy {
	public void route(String name) {
		System.out.println("Finding route for walking for " + name) ;
	}
}

class CyclingRoute implements RouteStrategy {
	public void route(String name) {
		System.out.println("Finding route for cycling for " + name) ;
	}
}

public class StrategyPattern {
	public static void main(String[] args) {
		Traveller traveller1 = new Walker("Shubham", new WalkingRoute());
		Traveller traveller2 = new Cyclist("Pujika", new WalkingRoute());

		traveller1.findRoute();
		traveller2.findRoute();

	}
}