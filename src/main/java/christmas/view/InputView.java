package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.OrderItem;
import christmas.validator.ValidateMenuAndQuantity;
import christmas.validator.ValidateVisitDate;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class InputView {

    public int requestVisitDate(){
        String input = console();
        ValidateVisitDate.validate(input);
        return Integer.parseInt(input);
    }



    private String console(){
        return Console.readLine();
    }
}
