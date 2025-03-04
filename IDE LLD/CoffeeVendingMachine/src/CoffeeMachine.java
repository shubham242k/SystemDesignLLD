import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    State state;
    Menu menu;
    Store store;

    Coffee selectedCoffee;
    int currentPayment;
    private static CoffeeMachine coffeeMachine;
    private CoffeeMachine(){
        menu = new Menu();
        store = new Store();
        state = new IdleState(this);
        initialize();
    }

    public synchronized static CoffeeMachine getInstance(){
        if(coffeeMachine == null) {
            coffeeMachine = new CoffeeMachine();
        }
        return coffeeMachine;
    }

    public void selectCoffee(Coffee coffee) {
        state.selectCoffee(coffee);
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(coin);
    }

    public void returnChange() {
        state.returnChange();
    }

    public void dispatchCoffee() {
        state.dispatch();
    }

    public void cancelCoffee() {
        state.cancelTransaction();
    }

    public void addInMenu(Coffee coffee){
        menu.addCoffeeToMenu(coffee, Status.AVAILABLE);
    }

    public void addIngredient(Ingredient ingredient, int quan) {
        store.addIngredient(ingredient, quan);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public Store getStore() {
        return this.store;
    }

    public Coffee getSelectedCoffee() {
        return this.selectedCoffee;
    }

    public void setSelectedCoffee(Coffee coffee) {
        this.selectedCoffee = coffee;
    }

    public void resetSelectedCoffee() {
        this.selectedCoffee = null;
        this.currentPayment = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getCurrentPayment() {
        return this.currentPayment;
    }

    public void updateCurrentPayment(int cur) {
        this.currentPayment = cur;
    }

    public void initialize() {
        Coffee coffee1 = new Coffee("Latte", 40);
        Coffee coffee2 = new Coffee("Black Coffee", 25);
        Coffee coffee3 = new Coffee("Espresso", 35);

        Map<Ingredient, Integer> recipe1 = new HashMap<>();
        recipe1.put(Ingredient.BEANS, 3);
        recipe1.put(Ingredient.WATER, 2);
        recipe1.put(Ingredient.CREAM, 4);
        recipe1.put(Ingredient.MILK, 2);
        recipe1.put(Ingredient.SUGAR, 1);
        coffee1.setIngredients(recipe1);

        Map<Ingredient, Integer> recipe2 = new HashMap<>();
        recipe2.put(Ingredient.BEANS, 3);
        recipe2.put(Ingredient.WATER, 2);
        coffee2.setIngredients(recipe2);

        Map<Ingredient, Integer> recipe3 = new HashMap<>();
        recipe3.put(Ingredient.BEANS, 4);
        recipe3.put(Ingredient.WATER, 3);
        recipe3.put(Ingredient.CREAM, 1);
        recipe3.put(Ingredient.MILK, 2);
        coffee3.setIngredients(recipe3);

        menu.makeCoffeeAvailable(coffee1);
        menu.makeCoffeeAvailable(coffee2);
        menu.makeCoffeeAvailable(coffee3);

        store.addIngredient(Ingredient.BEANS, 7);
        store.addIngredient(Ingredient.WATER, 10);
        store.addIngredient(Ingredient.CREAM, 20);
        store.addIngredient(Ingredient.MILK, 15);
        store.addIngredient(Ingredient.SUGAR, 30);
    }
}
