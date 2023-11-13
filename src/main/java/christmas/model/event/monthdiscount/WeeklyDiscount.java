package christmas.model.event.monthdiscount;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.menu.MenuItem;
import christmas.model.menu.MenuType;
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
        int totalDiscount=0;
        for (OrderItem orderitem:orderItems.getOrderItems()){
            String menuTypeString = getMenuTypeString(orderitem);
            if(menuTypeString=="MAIN"){
                totalDiscount+=WEEKEND_DISCOUNT_AMOUNT*orderitem.getQuantity();
            }
        }
        return totalDiscount;
    }

    private static String getMenuTypeString(OrderItem orderitem) {
        MenuItem menuItem = orderitem.getMenuItem();
        MenuType menuType = menuItem.getMenuType();
        String menuTypeString = menuType.toString();
        return menuTypeString;
    }

    private static int applyWeekdayDiscount(OrderItems orderItems) {
        return 0;
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek){
        return dayOfWeek==DayOfWeek.FRIDAY|| dayOfWeek==DayOfWeek.SATURDAY;
    }
}
