package christmas.validator;

public class ValidateVisitDate {
    
    static final int START_DATE=1;
    static final int END_DATE=31;
    public static void validate(String input){
        validateEmpty(input);
        validateNumerical(input);
        validateNumberRange(input);
    }

    private static void validateEmpty(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNotNumerical(String input) {
        return input.matches(".*\\D.*");
    }
}
