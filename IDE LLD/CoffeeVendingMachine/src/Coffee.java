import java.util.*;

public class Coffee {
    String name;
    int price;
    Map<Ingredient, Integer> ingredients;
    Coffee(String name, int price) {
        this.name = name;
        this.price = price;
        ingredients = new HashMap<>();
    }

    public String getCoffeeName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Map<Ingredient, Integer> ing) {
        this.ingredients = ing;
    }
}
