import java.util.ArrayList;
import java.util.List;

public class Order {
    String orderId;
    Table table;
    int bill;
    List<Food> foodList;
    OrderStatus status;
    public Order(String orderId, Table table) {
        this.orderId = orderId;
        this.table = table;
        bill = 0;
        foodList = new ArrayList<>();
    }

    void addFoodToOrder(Food food) {
        foodList.add(food);
        bill += food.getPrice();
    }

    public List<Food> getOrderedFood() {
        return this.foodList;
    }

    double getBill() {
        return this.bill + 0.1 * this.bill;
    }

    Table getTable() {
        return this.table;
    }

    void changeOrderStatus(OrderStatus orderStatus) {
        this.status = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return this.status;
    }
}
