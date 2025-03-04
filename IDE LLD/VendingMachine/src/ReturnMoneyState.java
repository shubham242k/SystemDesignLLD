public class ReturnMoneyState extends State{
    ReturnMoneyState(Machine machine) {
        super(machine);
    }
    @Override
    void selectProduct(Product product) {
        System.out.println("Prodcuct already been selected: " + machine.getSelectedProduct().getProductName());
    }

    @Override
    void insertMoney(int money) {
        System.out.println("Money already been paid.");
    }

    @Override
    void returnMoney() {
        if(machine.getTotalAmount() > machine.getSelectedProduct().getPrice()) {
            int change = machine.getTotalAmount() - machine.getSelectedProduct().getPrice();
            System.out.println("Collect the change: " + change);
        } else {
            System.out.println("Collect the change: " + 0);
        }
        machine.resetProduct();
        machine.setState(new IdleState(machine));
    }

    @Override
    void dispenseProduct() {
        System.out.println("First collect the extra amount you paid");
    }
}
