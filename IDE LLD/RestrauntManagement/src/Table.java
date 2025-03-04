public class Table {
    int tableNo;
    TableStatus status;

    Order order;
    Table(int tableNo) {
        this.tableNo = tableNo;
        this.status = TableStatus.VACANT;
    }

    public int getTableNo() {
        return this.tableNo;
    }

    public void orderFood(Food food) {
        if(order == null) order = new Order(String.valueOf(System.currentTimeMillis()), this);

        order.addFoodToOrder(food);
    }

    public Order getOrder() {
        return this.order;
    }
    public TableStatus getTableAvailabilityStatus() {
        return this.status;
    }

    public void occupyTable() {
        status = TableStatus.OCCUPIED;
    }

    public void vacateTable() {
        status = TableStatus.VACANT;
    }
}
