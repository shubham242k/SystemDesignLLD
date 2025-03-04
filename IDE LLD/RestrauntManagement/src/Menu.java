import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Food, Status> menu;
    Menu() {
        menu = new HashMap<>();
    }

    public void addFoodToMenu(Food food) {
        menu.put(food, Status.AVAILABLE);
    }

    public void makeFoodUnavailable(Food food) {
        menu.put(food, Status.UNAVAILABLE);
    }

    public boolean isAvailable(Food food) {
        return menu.getOrDefault(food, Status.UNAVAILABLE) == Status.AVAILABLE;
    }

    public Food chooseFood(String name) {
        for(Map.Entry<Food, Status> map : menu.entrySet()) {
            if (map.getKey().getName().equalsIgnoreCase(name)) {
                return map.getKey();
            }
        }
        return null;
    }
}
