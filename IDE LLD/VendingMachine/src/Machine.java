public class Machine {
    private static Machine machine;
    private Product selectedProduct;
    private int totalAmount;
    private State state;
    private Inventory inventory;
    private Machine(){
        inventory = new Inventory();
        state = new IdleState(this);
    }
    public static Machine getInstance() {
        if(machine == null) {
            machine = new Machine();
        }
        return machine;
    }

    public void selectProduct(Product prod) {
      state.selectProduct(prod);
    }

    public void insertMoney(int money) {
        state.insertMoney(money);
    }

    public void returnChange() {
        state.returnMoney();
    }

    public void dispatchProduct() {
        state.dispenseProduct();
    }
    public void setState(State state) {
        this.state = state;
    }

    public void setSelectProduct(Product product) {
        selectedProduct = product;
    }

    public Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public void addToAmount(int money) {
        totalAmount += money;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void resetProduct() {
        totalAmount = 0;
        selectedProduct = null;
    }
}