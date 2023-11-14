package christmas.controller;

import christmas.model.OrderItems;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    InputView inputView=new InputView();
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

}
