public class DispatchState extends  State{
    DispatchState(CoffeeMachine machine) {
        super(machine);
    }

    public void selectCoffee(Coffee coffee) {
        System.out.println("Coffee already been selected: " + machine.getSelectedCoffee().getCoffeeName());
    }

    public void dispatch(){
        System.out.println("Dispatching is in progress");
        System.out.println("Making the coffee");
        machine.getStore().takeIngredients(machine.getSelectedCoffee());
        if(!machine.getStore().sufficientIngredients(machine.getSelectedCoffee())) {
            machine.getMenu().makeCoffeeUnavailable(machine.getSelectedCoffee());
        }
        System.out.println("Coffee ready and dispatched: " + machine.getSelectedCoffee().getCoffeeName());
        machine.setState(new ReturnChangeState(machine));
    }
    public void insertCoin(Coin coin){
        System.out.println("Coin inserted: " + coin.getValue());
        machine.updateCurrentPayment(machine.getCurrentPayment() + coin.getValue());
        if(machine.getCurrentPayment() >= machine.getSelectedCoffee().getPrice()) {
            System.out.println("Complete Payment made. Proceeding for dispatching");
            machine.setState(new DispatchState(machine));
        }
    }
    public void returnChange(){
        if(machine.getCurrentPayment() > machine.getSelectedCoffee().getPrice()) {
            System.out.println("After dispatching, Changes will be returned: " + (machine.getCurrentPayment() - machine.getSelectedCoffee().getPrice()));
        }
    }
    public void cancelTransaction(){
        System.out.println("Cant cancel. Dispatching in progress");
    }
}
