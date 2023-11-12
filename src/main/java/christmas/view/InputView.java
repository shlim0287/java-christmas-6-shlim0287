package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.OrderItem;
import java.util.List;

public class InputView {

    public int requestVisitDate(){
        return Integer.parseInt(console());
    }


    private String console(){
        return Console.readLine();
    }
}
