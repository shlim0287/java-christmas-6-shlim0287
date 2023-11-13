package christmas.validator;

import christmas.model.OrderItem;
import christmas.model.menu.MenuType;
import java.util.List;

public class ValidateOrderInput {
    public static void validate(List<OrderItem> orderItems){
        validateTotalMenuCountExceedsLimit(orderItems);
        validateOnlyBeverages(orderItems);
    }

    private static void validateTotalMenuCountExceedsLimit(List<OrderItem> orderItems) {
        if(getTotalQuantityOfMenuItems(orderItems)>20){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static int getTotalQuantityOfMenuItems(List<OrderItem> orderItems) {
        int totalQuantity = 0;
        for (OrderItem orderItem : orderItems) {
            totalQuantity += orderItem.getQuantity();
        }
        return totalQuantity;
    }

    private static void validateOnlyBeverages(List<OrderItem> orderItems) {
        int count=0;
        for(OrderItem orderItem:orderItems){
            MenuType menuType = orderItem.getMenuItem().getMenuType();
            count = countNonBeverage(count, menuType);
        }
        validateNonBeverage(count);
    }

    private static int countNonBeverage(int count, MenuType menuType) {
        if(menuType.toString()!="BEVERAGE"){
            count++;
        }
        return count;
    }

    private static void validateNonBeverage(int count) {
        if(count ==0){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
