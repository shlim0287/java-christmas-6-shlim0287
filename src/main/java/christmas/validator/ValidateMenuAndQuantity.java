package christmas.validator;

public class ValidateMenuAndQuantity {
    public static void validate(String input){
        validateEmpty(input);

    }

    private static void validateEmpty(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해 주세요.");
        }
    }


}
