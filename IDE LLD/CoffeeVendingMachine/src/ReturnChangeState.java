public class ReturnChangeState extends  State{
    ReturnChangeState(CoffeeMachine machine) {
        super(machine);
    }

    public void selectCoffee(Coffee coffee) {
        if(machine.getMenu().checkAvailability(coffee)) {
            machine.setSelectedCoffee(coffee);
            machine.setState(new AcceptMoneyState(machine));
        }
    }

    public void dispatch(){
        System.out.println("Coffee already been dispatched. Collect the change");
    }
    public void insertCoin(Coin coin){
        System.out.println("Payment done and coffee dispatched. Collect the change");
    }
    public void returnChange(){
        if(machine.getCurrentPayment() >= machine.getSelectedCoffee().getPrice()) {
            System.out.println("Collect the change: " + (machine.getCurrentPayment() - machine.getSelectedCoffee().getPrice()));
            machine.resetSelectedCoffee();
            machine.setState(new IdleState(machine));
        } else if (machine.getCurrentPayment() < machine.getSelectedCoffee().getPrice()) {
            System.out.println("Transaction Cancel. Returning the payment: " + (machine.getCurrentPayment() - machine.getSelectedCoffee().getPrice()));
        }
        System.out.println("Enjoy your coffee");
    }
    public void cancelTransaction(){
        System.out.println("Cancel not possible. Collect the change");
    }
}
