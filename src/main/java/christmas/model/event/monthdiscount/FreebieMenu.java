package christmas.model.event.monthdiscount;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.event.Event;
import christmas.model.menu.MenuItem;

public class FreebieMenu implements Event {
    static final int APPLICABLE_FREEBIE_AMOUNT=120000;

    @Override
    public int calculateDiscount(OrderItems orderItems, int day) {
        OrderItem orderItem = applicableOrNot(orderItems);
        if(orderItem!=null){
            return orderItem.getTotalPrice();
        }
        return 0;
    }

    public static OrderItem applicableOrNot (OrderItems orderItems) {
        int totalOrderPrice= orderItems.getTotalPriceOfOrder(orderItems);
        int freebieCount=totalOrderPrice/APPLICABLE_FREEBIE_AMOUNT;
        return checkApplicable(freebieCount);
    }

    private static OrderItem checkApplicable(int freebieCount) {
        if(hasFreebie(freebieCount)){
            OrderItem orderItem = new OrderItem(MenuItem.CHAMPAGNE, freebieCount);
            return orderItem;
        }
        return null;
    }

    private static boolean hasFreebie(int freebieCount) {
        return freebieCount > 0;
    }

}
