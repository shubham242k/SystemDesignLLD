import java.util.HashMap;

public class Inventory {
    private HashMap<Product, Integer> products;
    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product prod, int quantity) {
        if(products.containsKey(prod)) {
            products.put(prod, products.get(prod) + quantity);
        } else {
            products.put(prod, quantity);
        }
    }

    public void removeProduct(Product prod) {
        products.remove(prod);
    }

    public boolean isAvailable(Product prod) {
        return products.containsKey(prod) && 0 <= products.get(prod);
    }

    public void updateQuantity(Product prod, int quantity) {
        products.put(prod, quantity);
    }

    public int getQuantity(Product prod) {
        return products.get(prod);
    }
}
