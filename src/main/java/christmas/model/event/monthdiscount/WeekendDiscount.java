package christmas.model.event.monthdiscount;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.event.Event;
import christmas.model.menu.MenuItem;
import christmas.model.menu.MenuType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscount implements Event {
    private static final int WEEKEND_DISCOUNT_AMOUNT=2023;
    @Override
    public int calculateDiscount(OrderItems orderItems, int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (isWeekend(dayOfWeek)) {
            return applyWeekendDiscount(orderItems);
        }
        return 0;
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    private static int applyWeekendDiscount(OrderItems orderItems) {
        int totalDiscount = 0;
        for (OrderItem orderitem : orderItems.getOrderItems()) {
            String menuTypeString = getMenuTypeString(orderitem);
            if ("MAIN".equals(menuTypeString)) {
                totalDiscount += WEEKEND_DISCOUNT_AMOUNT * orderitem.getQuantity();
            }
        }
        return totalDiscount;
    }

    private static String getMenuTypeString(OrderItem orderitem) {
        MenuItem menuItem = orderitem.getMenuItem();
        MenuType menuType = menuItem.getMenuType();
        return menuType.toString();
    }

    @Override
    public String getEventName() {
        return "주말 할인";
    }
}
