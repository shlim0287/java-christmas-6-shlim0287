package christmas.validator;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.menu.MenuType;
import java.util.List;

public class ValidateOrderInput {
    public static void validate(OrderItems orderItems){
        validateTotalMenuCountExceedsLimit(orderItems);
        validateOnlyBeverages(orderItems);
    }

    private static void validateTotalMenuCountExceedsLimit(OrderItems orderItems) {
        if(orderItems.getTotalQuantityOfMenuItems(orderItems.getOrderItems())>20){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }



    private static void validateOnlyBeverages(OrderItems orderItems) {
        int count=0;
        for(OrderItem orderItem:orderItems.getOrderItems()){
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
