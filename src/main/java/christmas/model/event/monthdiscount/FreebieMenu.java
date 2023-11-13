package christmas.model.event.monthdiscount;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.menu.MenuItem;

public class FreebieMenu {
    static final int APPLICABLE_FREEBIE_AMOUNT=120000;
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
