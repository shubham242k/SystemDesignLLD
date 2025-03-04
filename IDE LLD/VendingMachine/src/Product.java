public class Product {
    private String productName;
    private int price;
    public Product(String name, int price) {
        this.productName = name;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return this.price;
    }
}