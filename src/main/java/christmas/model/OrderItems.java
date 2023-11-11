package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {
    private List<OrderItem> orderItems=new ArrayList<>();

    public void addOrder(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
