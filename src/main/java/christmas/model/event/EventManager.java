package christmas.model.event;

import christmas.model.event.monthdiscount.FreebieMenu;
import christmas.model.event.monthdiscount.SpecialDiscount;
import christmas.model.event.monthdiscount.WeekdayDiscount;
import christmas.model.event.monthdiscount.WeekendDiscount;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<Event> events;

    public EventManager(List<Event> events) {
        this.events = new ArrayList<>();
        events.add(new ChristmasDiscount());
        events.add(new WeekdayDiscount());
        events.add(new WeekendDiscount());
        events.add(new SpecialDiscount());
        events.add(new FreebieMenu());
    }


}
