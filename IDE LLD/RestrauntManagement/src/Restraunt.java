import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;

public class Restraunt {
    Menu menu;
    List<Table> tableList;
    Kitchen kitchen;
    Restraunt(int n) {
        setUpRestraunt(n);
    }

    private void setUpRestraunt(int n) {
        tableList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            tableList.add(new Table(i + 1));
        }

        Menu menu = new Menu();
        menu.addFoodToMenu(new Food("Burger", new HashMap<Ingredient, Integer>(){{
            put(Ingredient.SUGAR, 1);
            put(Ingredient.SALT, 2);
            put(Ingredient.BREAD, 3);
            put(Ingredient.VEGETABLE, 3);
        }}, 100));
        menu.addFoodToMenu(new Food("SOUP", new HashMap<Ingredient, Integer>(){{
            put(Ingredient.SUGAR, 2);
            put(Ingredient.SALT, 2);
            put(Ingredient.VEGETABLE, 5);
            put(Ingredient.WATER, 5);
        }}, 100));
        menu.addFoodToMenu(new Food("PIZZA", new HashMap<Ingredient, Integer>(){{
            put(Ingredient.SUGAR, 2);
            put(Ingredient.SALT, 2);
            put(Ingredient.VEGETABLE, 5);
            put(Ingredient.WATER, 5);
        }}, 100));

        Inventory inventory = new Inventory();
        inventory.addIngredient(Ingredient.SUGAR, 10);
        inventory.addIngredient(Ingredient.VEGETABLE, 10);
        inventory.addIngredient(Ingredient.SALT, 10);
        inventory.addIngredient(Ingredient.WATER, 10);
        inventory.addIngredient(Ingredient.BREAD, 10);
        kitchen = new Kitchen(inventory, menu);
    }

    public Table makeReservation(int tableNo) {
        for(Table table : tableList) {
            if(table.getTableNo() == tableNo && table.getTableAvailabilityStatus() == TableStatus.VACANT) {
                table.occupyTable();
                System.out.println("Reservation done for table: " + tableNo);
                return table;
            }
        }
        System.out.println("Table: " + tableNo + " is already occupied");
        return null;
    }

    public void chooseFood(Table table, Food food) {
        boolean avail = menu.isAvailable(food);
        if(avail) {
            table.orderFood(food);
            System.out.println(food.getName() + "is added to order of table " + table.getTableNo());
        } else {
            System.out.println(food.getName() + "is not available");
        }
    }
    public void orderFood(Table table) {
        kitchen.prepareOrder(table.getOrder());
    }

    public void makePayment(Table table) {
        Order order = table.order;
        if(order.getOrderStatus() == OrderStatus.PAYMENT_PENDING) {
            System.out.println("Pay: " + order.getBill());
            order.changeOrderStatus(OrderStatus.CLOSE);
        }
        table.order = null;
        table.vacateTable();
        System.out.println("Table: " + table.getTableNo() + " is vacated");
    }
}
