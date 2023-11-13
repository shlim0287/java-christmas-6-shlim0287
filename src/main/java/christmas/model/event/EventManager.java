package christmas.model.event;

import christmas.model.OrderItems;
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

    public int calculateTotalDiscount(OrderItems orderItems,int day){
        int totalDiscount=0;
        for(Event event:events){
            totalDiscount+=event.calculateDiscount(orderItems,day);
        }
        return totalDiscount;
    }

    public List<Event> getApplicableEvent(OrderItems orderItems,int day){
        List<Event> applicableEvents=new ArrayList<>();
        
        for(Event event:events){
            validateApplicable(orderItems, day, applicableEvents, event);
        }
        return applicableEvents;
    }

    private static void validateApplicable(OrderItems orderItems, int day, List<Event> applicableEvents, Event event) {
        int discount = event.calculateDiscount(orderItems, day);
        if(discount!=0){
            applicableEvents.add(event);
        }
    }

}
