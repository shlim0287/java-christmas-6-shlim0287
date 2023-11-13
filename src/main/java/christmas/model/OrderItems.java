package christmas.model;

import christmas.model.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class OrderItems {
    private List<OrderItem> orderItems=new ArrayList<>();

    public void addOrder(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public MenuItem findMenuItemByName(String menuName){
        for(OrderItem orderItem:orderItems){
            String menuNameInOrderItem = orderItem.getMenuItem().getMenuName();
            if(menuNameInOrderItem.equals(menuName)){
                return orderItem.getMenuItem();
            }
        }
        return null;
    }

    public int getTotalQuantityOfMenuItems(List<OrderItem> orderItems) {
        int totalQuantity = 0;
        for (OrderItem orderItem : orderItems) {
            totalQuantity += orderItem.getQuantity();
        }
        return totalQuantity;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
