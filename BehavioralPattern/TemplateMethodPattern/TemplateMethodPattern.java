abstract class BrewMaker {
	public void makeBrew() {
		boilWater();
		addIngredients();
		brew();
		pour();
	}

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public void pour() {
		System.out.println("Pouring in cup");
	}

	abstract void brew();
	abstract void addIngredients();
}

class TeaMaker extends BrewMaker {
	public void brew() {
		System.out.println("Tea is brewing");
	}

	public void addIngredients() {
		System.out.println("Adding tea leaves and sugar");
	}
}

class CoffeeMaker extends BrewMaker {
	public void brew() {
		System.out.println("Coffee is brewing");
	}

	public void addIngredients() {
		System.out.println("Adding coffee beans and caramalizing");
	}
}

public class TemplateMethodPattern {
	public static void main(String[] args) {
		BrewMaker tea = new TeaMaker();
		tea.makeBrew();

		BrewMaker coffee = new CoffeeMaker();
		coffee.makeBrew();
	}
}