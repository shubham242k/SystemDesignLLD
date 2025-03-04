abstract class Pizza {
	int price;
	Pizza(int price) {
		this.price = price;
	}

	abstract int getPrice();
}

class VegPizza extends Pizza {

	VegPizza(int price) {
		super(price);
	}

	public int getPrice() {
		return price;
	}
}

class NonVegPizza extends Pizza {
	NonVegPizza(int price) {
		super(price);
	}

	public int getPrice() {
		return price + 20;
	}
}

abstract class Decorator extends Pizza {
	Pizza pizza;
	Decorator(Pizza pizza, int price) {
		super(price);
		this.pizza = pizza;
	}
}

class CheeseDecorator extends Decorator {
	CheeseDecorator(Pizza pizza, int price) {
		super(pizza, price);
	}

	public int getPrice() {
		return pizza.getPrice() + this.price;
	}
}

class ToppingDecorator extends Decorator {
	ToppingDecorator(Pizza pizza, int price) {
		super(pizza, price);
	}

	public int getPrice() {
		return pizza.getPrice() + 2 * this.price;
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		Pizza basePiza = new VegPizza(100);

		Pizza cheeseToppingPizza = new ToppingDecorator(new CheeseDecorator(new VegPizza(100), 50), 20);
		System.out.println(cheeseToppingPizza.getPrice());
	}
}