import java.util.HashMap;
import java.util.Map;

public class Store {
    Map<Ingredient, Integer> ingredients;
    Store() {
        this.ingredients = new HashMap<>();
    }

    public Map<Ingredient, Integer> getIngredients() {
        return this.ingredients;
    }

    public void displayStore() {
        for (Map.Entry<Ingredient, Integer> ing : ingredients.entrySet()) {
            System.out.println(ing.getKey() + " " + ing.getValue());
        }
        System.out.println("---------");
    }

    public void setIngredients() {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient, int quan) {
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + quan);
    }

    public void removeIngredient(Ingredient ingredient, int quan) {
        if(!ingredients.containsKey(ingredient) || ingredients.get(ingredient) < quan) return;
        ingredients.put(ingredient, ingredients.get(ingredient) - quan);
    }

    public boolean sufficientIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> ing : coffee.getIngredients().entrySet()) {
            if(!ingredients.containsKey(ing.getKey()) || ingredients.get(ing.getKey()) < ing.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void takeIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> ing : coffee.getIngredients().entrySet()) {
            removeIngredient(ing.getKey(), ing.getValue());
        }
    }
}
