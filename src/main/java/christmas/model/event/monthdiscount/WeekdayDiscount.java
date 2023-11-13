package christmas.model.event.monthdiscount;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.event.Event;
import christmas.model.menu.MenuItem;
import christmas.model.menu.MenuType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscount implements Event {
    private static final int WEEKDAY_DISCOUNT_AMOUNT=2023;
    @Override
    public int calculateDiscount(OrderItems orderItems, int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (!isWeekend(dayOfWeek)) {
            return applyWeekdayDiscount(orderItems);
        }
        return 0;
    }
    private static int applyWeekdayDiscount(OrderItems orderItems) {
        int totalDiscount = 0;
        for (OrderItem orderitem : orderItems.getOrderItems()) {
            String menuTypeString = getMenuTypeString(orderitem);
            if ("DESSERT".equals(menuTypeString)) {
                totalDiscount += WEEKDAY_DISCOUNT_AMOUNT * orderitem.getQuantity();
            }
        }
        return totalDiscount;
    }

    private static String getMenuTypeString(OrderItem orderitem) {
        MenuItem menuItem = orderitem.getMenuItem();
        MenuType menuType = menuItem.getMenuType();
        return menuType.toString();
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    @Override
    public String getEventName() {
        return "평일 할인";
    }
}
