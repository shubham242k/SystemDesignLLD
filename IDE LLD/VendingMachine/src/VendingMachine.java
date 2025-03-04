public class VendingMachine {
    public static void main(String[] args) {
        Machine vendingMachine = Machine.getInstance();
        Product coke = new Product("Coke", 10);
        Product pepsi = new Product("Pepsi", 15);
        Product water = new Product("Water", 20);

        vendingMachine.getInventory().addProduct(coke, 5);
        vendingMachine.getInventory().addProduct(pepsi, 3);
        vendingMachine.getInventory().addProduct(water, 2);

        vendingMachine.selectProduct(coke);

        vendingMachine.insertMoney(20);

        vendingMachine.dispatchProduct();

        vendingMachine.returnChange();

    }
}
