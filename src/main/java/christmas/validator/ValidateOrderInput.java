package christmas.validator;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import java.util.List;

public class ValidateOrderInput {
    public static void validate(List<OrderItem> orderItems){
        validateTotalMenuCountExceedsLimit(orderItems);
        validateOnlyBeverages();
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

    private static void validateOnlyBeverages() {
    }
}
