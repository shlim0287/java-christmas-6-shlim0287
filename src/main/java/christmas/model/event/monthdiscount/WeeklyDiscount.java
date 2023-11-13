package christmas.model.event.monthdiscount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyDiscount {
    private static final int WEEKDAY_DISCOUNT_AMOUNT=2023;
    private static final int WEEKEND_DISCOUNT_AMOUNT=2023;

    public static int calculateDiscount(int day){
        LocalDate date=LocalDate.of(2023,12,day);
        DayOfWeek dayOfWeek=date.getDayOfWeek();

        if(isWeekend(dayOfWeek)){
            return applyWeekendDiscount(day);
        }
        if(!isWeekend(dayOfWeek)){
            return applyWeekdayDiscount(day);
        }
        return 0;
    }

    private static int applyWeekendDiscount(int day) {
        return 0;
    }

    private static int applyWeekdayDiscount(int day) {
        return 0;
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek){
        return dayOfWeek==DayOfWeek.FRIDAY|| dayOfWeek==DayOfWeek.SATURDAY;
    }
}
