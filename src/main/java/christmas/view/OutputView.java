package christmas.view;

import christmas.model.Badge;
import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.event.Event;
import christmas.model.event.EventManager;
import christmas.model.event.monthdiscount.FreebieMenu;
import java.util.List;

public class OutputView {
    public static void printRequestVisitDate(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
                + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void printRequestOrderMenuAndQuantity(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printPreviewEventBenefits(int visitDate){
        System.out.println("12월 "+visitDate+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
    public static void printOrderedMenus(OrderItems orderItems){
        System.out.println("<주문 메뉴>");
        for(OrderItem orderItem:orderItems.getOrderItems()){
            System.out.println(orderItem.getMenuItem().getMenuName()+" "+orderItem.getQuantity()+"개");
        }
    }

    public static void printTotalPriceOfOrder(OrderItems orderItems){
        System.out.println("<할인 전 총주문 금액>");
        int totalPriceOfOrder = orderItems.getTotalPriceOfOrder(orderItems);
        System.out.println(totalPriceOfOrder);
    }

    public static void printFreebieApplicable(OrderItems orderItems){
        System.out.println("<증정 메뉴>");
        OrderItem orderItem = FreebieMenu.applicableOrNot(orderItems);

        if(orderItem!=null){
            System.out.println(orderItem.getMenuItem().getMenuName()+" "+orderItem.getQuantity()+"개");
        }
        if(orderItem==null){
            System.out.println("없음");
        }
    }

    public static void printEventBenefit(OrderItems orderItems,int visitDate,EventManager manager){
        System.out.println("<혜택 내역>");
        List<Event> applicableEvent = manager.getApplicableEvent(orderItems, visitDate);
        if(manager.calculateTotalDiscount(orderItems,visitDate)==0){
            System.out.println("없음");
        }
        for (Event event : applicableEvent) {
            int discount = event.calculateDiscount(orderItems, visitDate);
            if (discount != 0) {
                System.out.printf("%s: -%,d원\n", event.getEventName(), discount);
            }
        }
    }

    public static void printTotalDiscount(OrderItems orderItems,int visitDate,EventManager manager){
        System.out.println("<총혜택 금액>");
        int totalDiscount = manager.calculateTotalDiscount(orderItems, visitDate);
        if(totalDiscount!=0){
            System.out.printf("-%,d원\n",totalDiscount );
        }
        if(totalDiscount==0){
            System.out.println("없음");
        }
    }

    public static void printExpectedPrice(OrderItems orderItems,EventManager manager,int day){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", orderItems.getTotalPriceOfOrder(orderItems)-manager.calculateTotalDiscount(orderItems,day));
    }

    public static void printEventBadge(OrderItems orderItems,int visitDate,EventManager manager){
        System.out.println("<12월 이벤트 배지>");
        String badge = Badge.getCategory(manager.calculateTotalDiscount(orderItems, visitDate));
        System.out.println(badge);
    }
}
