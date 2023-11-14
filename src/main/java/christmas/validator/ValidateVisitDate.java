package christmas.validator;

public class ValidateVisitDate {
    
    static final int START_DATE=1;
    static final int END_DATE=31;
    public static String validate(String input){
        return validateEmpty(input)+validateNumerical(input)+validateNumberRange(input);
    }

    private static String validateEmpty(String input) {
        if(input.isBlank()){
            return "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
        }
        return "";
    }

    private static String validateNumberRange(String input) {
        int visitDate = Integer.parseInt(input);
        if(isOutOfRange(visitDate)){
            return "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
        }
        return "";
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

    private static String validateNumerical(String input) {
        if(isNotNumerical(input)){
            return "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
        }
        return "";
    }

    private static boolean isNotNumerical(String input) {
        return input.matches(".*\\D.*");
    }
}
