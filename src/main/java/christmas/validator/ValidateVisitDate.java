package christmas.validator;

public class ValidateVisitDate {
    
    static final int START_DATE=1;
    static final int END_DATE=31;
    public static void validate(String input){
        validateEmpty(input);
        validateNumberRange(input);
        validateNumerical(input);
    }

    private static void validateEmpty(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해 주세요.");
        }
    }

    private static void validateNumberRange(String input) {
        int visitDate = Integer.parseInt(input);
        if(isOutOfRange(visitDate)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
    
    private static boolean isOutOfRange(int visitDate){
        if(visitDate<START_DATE){
            return true;
        }
        if(visitDate>END_DATE){
            return true;
        }
        return false;
    }

    private static void validateNumerical(String input) {
        if(isNotNumerical(input)){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNotNumerical(String input) {
        return input.matches("-?\\d+");
    }
}
