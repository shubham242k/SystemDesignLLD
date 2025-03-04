import java.util.*;
class Product {
	private String name;
	private int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName(){
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}

interface Iterator {
	boolean hasNext();
	Product next();
	Product first();
}

class ProductIterator implements Iterator {
	List<Product> list;
	int current;
	ProductIterator(List<Product> list){
		this.list = list;
		current = 0;
	}

	public Product first() {
		if(list.size() > 0) return list.get(0);
		return null;
	}
	public boolean hasNext(){
		return current < list.size() - 1;
	}

	public Product next() {
		if(hasNext()) {
			return list.get(++current);
		}

		return null;
	}

}

class Inventory {
	List<Product> list;

	Inventory() {
		list = new ArrayList<>();
	}

	void add(Product prod) {
		list.add(prod);
	}

	public Iterator createIterator(){
		return new ProductIterator(list);
	}
}
public class IteratorPattern {
	public static void main(String[] args) {
		Product prod1 = new Product("a",1);
		Product prod2 = new Product("b",2);

		Inventory inv = new Inventory();
		inv.add(prod1);
		inv.add(prod2);

		Iterator prodIterator = inv.createIterator();

		Product cur = prodIterator.first();

		while(cur != null) {
			System.out.println(cur.getName() + " " + cur.getPrice());
			cur = prodIterator.next();
		}
	}
}