import java.util.HashMap;
import java.util.Map;

public class CoffeeMachineDemo {
    public static void main(String[] args) {
        CoffeeMachine machine = CoffeeMachine.getInstance();

        Menu menu = machine.getMenu();
        menu.displayMenu();
        machine.getStore().displayStore();
        Coffee coffee = menu.chooseCoffe("Latte");
        machine.selectCoffee(coffee);

        machine.insertCoin(Coin.NICKEL);
        machine.insertCoin(Coin.NICKEL);
        machine.insertCoin(Coin.DIME);

        machine.dispatchCoffee();
        machine.returnChange();
        machine.cancelCoffee();
        machine.getStore().displayStore();
        menu.displayMenu();
    }
}
