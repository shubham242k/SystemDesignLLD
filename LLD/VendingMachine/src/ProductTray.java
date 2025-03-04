public class ProductTray {
	Product product;
	int quantities;
	int price;
	String code;
	public ProductTray(Product prod, int quan, int price, String code) {
		this.product = prod;
		this.quantities = quan;
		this.price = price;
		this.code = code;
	}

	public Product getProduct() {return product;}
	public int getQuantity() {return quantities;}
	public int getPrice() {return price;}
	public String getCode() {return code;}
	public void setQuantity(int quan) {this.quantities = quan;}
	public boolean isEmpty() {return quantities == 0;}
}