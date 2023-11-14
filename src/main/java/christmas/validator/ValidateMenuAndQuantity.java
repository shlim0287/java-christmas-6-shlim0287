package christmas.validator;

import java.util.StringTokenizer;

public class ValidateMenuAndQuantity {
    public static void validate(String input){
        validateEmpty(input);
        validateOrderFormat(input);
        validateMenuOrders(input);
    }

    private static void validateEmpty(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateOrderFormat(String input){
        if(!isMatchesOrderFormat(input)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isMatchesOrderFormat(String input) {
        return input.matches("^[^,]+-\\d+(,[^,]+-\\d+)*$");
    }

    private static void validateMenuOrders(String input){
        StringTokenizer tokenizer=new StringTokenizer(input,",");
        while(tokenizer.hasMoreTokens()){
            validateMenuOrder(tokenizer);
        }

    }

    private static void validateMenuOrder(StringTokenizer tokenizer) {
        if(!isMatchesMenuOrder(tokenizer.nextToken())){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isMatchesMenuOrder(String input) {
        return input.matches("^[^,]+-\\d+$");
    }

}
