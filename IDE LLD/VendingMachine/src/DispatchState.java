public class DispatchState extends State{
    DispatchState(Machine machine) {
        super(machine);
    }
    @Override
    void selectProduct(Product product) {
        System.out.println("Product already been selected: " + machine.getSelectedProduct().getProductName());
    }

    @Override
    void insertMoney(int money) {
        System.out.println("Money already been paid.");
    }

    @Override
    void returnMoney() {
        System.out.println("Extra has been returned");
    }

    @Override
    void dispenseProduct() {
        Product prod = machine.getSelectedProduct();
        machine.getInventory().updateQuantity(prod, machine.getInventory().getQuantity(prod) - 1);
        System.out.println("Product dispensed: " + prod.getProductName());
        machine.setState(new ReturnMoneyState(machine));
    }
}
