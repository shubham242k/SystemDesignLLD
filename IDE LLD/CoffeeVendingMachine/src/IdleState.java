public class IdleState extends  State{
    IdleState(CoffeeMachine machine) {
        super(machine);
    }

    public void selectCoffee(Coffee coffee) {
        if(machine.getMenu().checkAvailability(coffee)) {
            machine.setSelectedCoffee(coffee);
            machine.setState(new AcceptMoneyState(machine));
            System.out.println("Coffee selected: " + machine.getSelectedCoffee().getCoffeeName());
        }
    }

    public void dispatch(){
        System.out.println("First select the product");
    }
    public void insertCoin(Coin coin){
        System.out.println("First select the product");
    }
    public void returnChange(){
        System.out.println("First select the product");
    }
    public void cancelTransaction(){
        System.out.println("Already at idle state");
    }
}
