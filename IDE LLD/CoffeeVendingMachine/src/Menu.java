import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<Coffee, Status> menu;

    Menu() {
        menu = new HashMap<>();
    }

    Menu(HashMap<Coffee, Status> menu) {
        this.menu = menu;
    }

    public Map<Coffee, Status> getMenu() {
        return this.menu;
    }

    public void addCoffeeToMenu(Coffee coffee, Status status) {
        menu.put(coffee, status);
    }

    public void makeCoffeeUnavailable(Coffee coffee) {
        this.menu.put(coffee, Status.UNAVAILABLE);
    }

    public void makeCoffeeAvailable(Coffee coffee) {
        this.menu.put(coffee, Status.AVAILABLE);
    }

    public boolean checkAvailability(Coffee coffee) {
        return (menu.containsKey(coffee) && menu.get(coffee) == Status.AVAILABLE);
    }

    public void displayMenu() {
        for(Map.Entry<Coffee, Status> map : menu.entrySet()) {
            System.out.println(map.getKey().getCoffeeName() + " " + map.getValue() + " $" + map.getKey().getPrice());
        }
        System.out.println("---------");
    }

    public Coffee chooseCoffe(String name) {
        for(Map.Entry<Coffee, Status> map : menu.entrySet()) {
            if (map.getKey().getCoffeeName().equalsIgnoreCase(name)) {
                return map.getKey();
            }
        }
        return null;
    }
}
