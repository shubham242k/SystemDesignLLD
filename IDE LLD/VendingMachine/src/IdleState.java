public class IdleState extends State{
    IdleState(Machine machine) {
        super(machine);
    }

    @Override
    void selectProduct(Product product) {
        if(machine.getInventory().isAvailable(product)) {
            machine.setSelectProduct(product);
            machine.setState(new ReceiveMoneyState(machine));
            System.out.println("Product selected: " + product.getProductName());
        } else {
            System.out.println("Product not available: " + product.getProductName());
        }
    }

    @Override
    void insertMoney(int money) {
        System.out.println("First choose product");
    }

    @Override
    void returnMoney() {
        System.out.println("First choose product");
    }

    @Override
    void dispenseProduct() {
        System.out.println("First choose product");
    }
}
