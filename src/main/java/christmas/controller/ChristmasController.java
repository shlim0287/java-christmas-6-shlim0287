package christmas.controller;

import christmas.model.OrderItems;
import christmas.model.event.EventManager;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.mockito.internal.matchers.Or;

public class ChristmasController {
    InputView inputView=new InputView();
    EventManager manager=new EventManager();

    public void run(){
        int visitDate = requestVisitDate();
        OrderItems orderItems = requestOrderMenuAndQuantity();
        printPreviewEventBenefits(visitDate);
        printOrderedMenus(orderItems);
        printTotalPriceOfOrder(orderItems);
        printFreebieApplicable(orderItems);
        printEventBenefit(orderItems, visitDate, manager);
        printTotalDiscount(orderItems, visitDate, manager);
        printExpectedPrice(orderItems,visitDate,manager);
        printEventBadge(orderItems,visitDate,manager);
    }

    private int requestVisitDate(){
        OutputView.printRequestVisitDate();
        while(true){
            try{
                return inputView.requestVisitDate();
            }catch (IllegalArgumentException e){
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private OrderItems requestOrderMenuAndQuantity(){
        OutputView.printRequestOrderMenuAndQuantity();
        while(true){
            try {
                return inputView.requestOrderMenuAndQuantity();
            }catch (IllegalArgumentException e){
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printPreviewEventBenefits(int visitDate){
        OutputView.printPreviewEventBenefits(visitDate);
    }

    private void printOrderedMenus(OrderItems orderItems){
        OutputView.printOrderedMenus(orderItems);
    }

    private void printTotalPriceOfOrder(OrderItems orderItems){
        OutputView.printTotalPriceOfOrder(orderItems);
    }

    private void printFreebieApplicable(OrderItems orderItems){
        OutputView.printFreebieApplicable(orderItems);
    }

    private void printEventBenefit(OrderItems orderItems,int visitDate,EventManager manager){
        OutputView.printEventBenefit(orderItems,visitDate,manager);
    }

    private void printTotalDiscount(OrderItems orderItems,int visitDate,EventManager manager){
        OutputView.printTotalDiscount(orderItems,visitDate,manager);
    }

    private void printExpectedPrice(OrderItems orderItems,int visitDate,EventManager manager){
        OutputView.printExpectedPrice(orderItems,manager,visitDate);
    }

    private void printEventBadge(OrderItems orderItems,int visitDate,EventManager manager){
        OutputView.printEventBadge(orderItems,visitDate,manager);
    }
}
