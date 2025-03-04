public class AcceptMoneyState extends  State{
    AcceptMoneyState(CoffeeMachine machine) {
        super(machine);
    }

    public void selectCoffee(Coffee coffee) {
        System.out.println("Coffee already been selected: " + machine.getSelectedCoffee().getCoffeeName());
    }

    public void dispatch(){
        System.out.println("First insert the coins: " + (machine.getSelectedCoffee().getPrice() - machine.getCurrentPayment()));
    }
    public void insertCoin(Coin coin){
        System.out.println("Coin inserted: " + coin.getValue());
        machine.updateCurrentPayment(machine.getCurrentPayment() + coin.getValue());
        if(machine.getCurrentPayment() >= machine.getSelectedCoffee().getPrice()) {
            System.out.println("Complete Payment made. Proceeding for dispatching");
            machine.setState(new DispatchState(machine));
        } else {
            System.out.println("Money left to pay: " + (machine.getSelectedCoffee().getPrice() - machine.getCurrentPayment()));
        }
    }
    public void returnChange(){
        System.out.println("First insert the coins: " + (machine.getSelectedCoffee().getPrice() - machine.getCurrentPayment()));
    }
    public void cancelTransaction(){
        if(machine.getCurrentPayment() != 0) {
            machine.setState(new ReturnChangeState(machine));
            machine.getState().returnChange();
        }
        System.out.println("Cancelling the transaction");
        machine.setState(new IdleState(machine));
    }
}
