package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.utils.MenuOrderParser;
import christmas.validator.ValidateMenuAndQuantity;
import christmas.validator.ValidateOrderInput;
import christmas.validator.ValidateVisitDate;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class InputView {

    public int requestVisitDate(){
        String input = console();
        ValidateVisitDate.validate(input);
        return Integer.parseInt(input);
    }

    public OrderItems requestOrderMenuAndQuantity(){
        String input = console();
        ValidateMenuAndQuantity.validate(input);
        MenuOrderParser parser=new MenuOrderParser();
        OrderItems orderItems = parser.parseMenuOrder(input);
        ValidateOrderInput.validate(orderItems);
        return orderItems;
    }



    private String console(){
        return Console.readLine();
    }
}
