public class Machine {
	private static Machine machine;
	ProductTray[] shelfs;
	CashCounter cashCounter;
	State state;
	private Machine(){}

	public static Machine getInstance() {
		if(machine == null) {
			machine = new Machine();
		}
		return machine;
	}

	public void initiliaze() {
		Product prod1 = new Product("Chips");
		Product prod2 = new Product("Buiscuit");
		Product prod3 = new Product("Chocolate");
		Product prod4 = new Product("Beverage");
		Product prod5 = new Product("Snacks");
		shelfs = new ProductTray[5];
		shelfs[0] = new ProductTray(prod1, 2, 10, "101");
		shelfs[1] = new ProductTray(prod2, 1, 30, "102");
		shelfs[2] = new ProductTray(prod3, 3, 05, "103");
		shelfs[3] = new ProductTray(prod4, 4, 20, "104");
		shelfs[4] = new ProductTray(prod5, 0, 15, "105");
		cashCounter = new CashCounter(100);
	}

	public void setState(State newState) {
		state = newState;
	}
}