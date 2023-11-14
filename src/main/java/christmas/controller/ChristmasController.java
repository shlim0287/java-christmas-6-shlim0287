package christmas.controller;

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
                System.out.println(e.getMessage());
            }
        }
    }

}
