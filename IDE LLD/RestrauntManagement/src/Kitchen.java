public class Kitchen {
    Inventory inventory;
    Menu menu;

    Kitchen(Inventory inventory, Menu menu) {
        this.inventory = inventory;
        this.menu = menu;
    }

    private void prepareFood(Food food) {
        inventory.removeFoodIngredientsFromInventory(food.getIngredientsRequired());
    }

    public void prepareOrder(Order order) {
        System.out.println("Food is being prepared: " + order.getOrderedFood().toString());
        for(Food food : order.getOrderedFood()) {
            prepareFood(food);
        }
        makeFoodUnavailable(order);
        dispatchOrderToTable(order);
    }
    private void makeFoodUnavailable(Order order) {
        for(Food food : order.getOrderedFood()) {
            boolean isAvailable = inventory.haveSufficientIngredientForFood(food.ingredientsRequired);
            if (isAvailable) return;
            System.out.println("Food has got out of stock: " + food.getName());
            menu.makeFoodUnavailable(food);
        }
    }

    private void dispatchOrderToTable(Order order) {
        System.out.println("Food is being delivered to Table: " + order.getTable().getTableNo());
        order.changeOrderStatus(OrderStatus.FOOD_DELIVERED);
    }

}
