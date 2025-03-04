public abstract class State {
    Machine machine;
    State(Machine machine) {
        this.machine = machine;
    }
    abstract void selectProduct(Product product);
    abstract void insertMoney(int money);
    abstract void returnMoney();
    abstract void dispenseProduct();
}
