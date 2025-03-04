import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Ingredient, Integer> inventoryMap;
    Inventory() {
        inventoryMap = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, int quantity) {
        inventoryMap.put(ingredient, inventoryMap.getOrDefault(ingredient, 0) + quantity);
    }

    private void removeIngredient(Ingredient ingredient, int quantity) {
        inventoryMap.put(ingredient, inventoryMap.get(ingredient) - quantity);
    }

    public boolean haveSufficientIngredientForFood(Map<Ingredient, Integer> requiredMap) {
        for(Map.Entry<Ingredient, Integer> val : requiredMap.entrySet()) {
            if(!inventoryMap.containsKey(val.getKey()) || inventoryMap.get(val.getKey()) < val.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void removeFoodIngredientsFromInventory(Map<Ingredient, Integer> requiredMap) {
        for(Map.Entry<Ingredient, Integer> val : requiredMap.entrySet()) {
            removeIngredient(val.getKey(), val.getValue());
        }
    }
}
