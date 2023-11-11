package christmas.validator;

public class ValidateMenuAndQuantity {
    public static void validate(String input){
        validateEmpty(input);
        validateOrderFormat(input);

    }

    private static void validateEmpty(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해 주세요.");
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

}
