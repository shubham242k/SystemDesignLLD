public class ReceiveMoneyState extends State{
    ReceiveMoneyState(Machine machine) {
        super(machine);
    }
    @Override
    void selectProduct(Product product) {
        System.out.println("Prodcuct already been selected: " + machine.getSelectedProduct().getProductName());
    }

    @Override
    void insertMoney(int money) {
        System.out.println("Coin inserted " + money);
        machine.addToAmount(money);
        isSufficient();
    }

    @Override
    void returnMoney() {
        System.out.println("Please pay first");
    }

    @Override
    void dispenseProduct() {
        System.out.println("Please pay first");
    }

    private void isSufficient(){
        if(machine.getSelectedProduct().getPrice() > machine.getTotalAmount()) {
            System.out.println("Till now you paid " + machine.getTotalAmount() );
            System.out.println("Please insert " + (machine.getSelectedProduct().getPrice() - machine.getTotalAmount()) + " more.");
        } else {
            machine.setState(new DispatchState(machine));
        }
    }
}
