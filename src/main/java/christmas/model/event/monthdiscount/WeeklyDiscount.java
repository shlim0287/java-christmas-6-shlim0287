package christmas.model.event.monthdiscount;

import christmas.model.OrderItems;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyDiscount {
    private static final int WEEKDAY_DISCOUNT_AMOUNT=2023;
    private static final int WEEKEND_DISCOUNT_AMOUNT=2023;

    public static int calculateDiscount(int day, OrderItems orderItems){
        LocalDate date=LocalDate.of(2023,12,day);
        DayOfWeek dayOfWeek=date.getDayOfWeek();

        if(isWeekend(dayOfWeek)){
            return applyWeekendDiscount(orderItems);
        }
        if(!isWeekend(dayOfWeek)){
            return applyWeekdayDiscount(orderItems);
        }
        return 0;
    }

    private static int applyWeekendDiscount(OrderItems orderItems) {
        return 0;
    }

    private static int applyWeekdayDiscount(OrderItems orderItems) {
        return 0;
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek){
        return dayOfWeek==DayOfWeek.FRIDAY|| dayOfWeek==DayOfWeek.SATURDAY;
    }
}
