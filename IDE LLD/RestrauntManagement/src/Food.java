import java.util.HashMap;

public class Food {
    String name;
    int price;
    HashMap<Ingredient, Integer> ingredientsRequired;

    Food(String name, HashMap<Ingredient, Integer> map, int price) {
        this.name = name;
        this.ingredientsRequired = map;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }


    public HashMap<Ingredient, Integer> getIngredientsRequired() {
        return this.ingredientsRequired;
    }

    public String getName() {
        return this.name;
    }
}
