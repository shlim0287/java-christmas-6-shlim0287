package christmas;

import christmas.controller.ChristmasController;
import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.event.Event;
import christmas.model.event.EventManager;
import christmas.model.event.monthdiscount.FreebieMenu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ChristmasController controller=new ChristmasController();
        controller.run();
    }
}
