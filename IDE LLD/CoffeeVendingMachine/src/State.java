public abstract class State {
    CoffeeMachine machine;
    State(CoffeeMachine machine) {
        this.machine = machine;
    }

    public abstract void selectCoffee(Coffee coffee);

    public abstract void dispatch();

    public abstract void insertCoin(Coin coin);

    public abstract void returnChange();

    public abstract void cancelTransaction();
}
