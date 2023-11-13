package christmas.model.event;

import christmas.model.OrderItem;
import christmas.model.OrderItems;

public interface Event {
    int calculateDiscount(OrderItems orderItems, int day);
}
