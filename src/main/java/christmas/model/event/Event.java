package christmas.model.event;

import christmas.model.OrderItem;

public interface Event {
    int calculateDiscount(OrderItem orderItem,int day);
}
