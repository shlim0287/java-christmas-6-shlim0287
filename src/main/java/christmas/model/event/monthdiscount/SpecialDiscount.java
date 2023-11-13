package christmas.model.event.monthdiscount;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.event.Event;
import java.time.LocalDate;
import java.util.Set;

public class SpecialDiscount implements Event {
    private static final Set<Integer> SPECIAL_DISCOUNT_DAYS=Set.of(3,10,17,24,25,31);
    private static final int SPECIAL_DISCOUNT_AMOUNT=1000;

    @Override
    public int calculateDiscount(OrderItems orderItems, int day){
        if(isSpecialDiscountDay(day)){
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private boolean isSpecialDiscountDay(int day){
        return SPECIAL_DISCOUNT_DAYS.contains(day);
    }
}
