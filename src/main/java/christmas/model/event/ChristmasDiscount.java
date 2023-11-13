package christmas.model.event;

public class ChristmasDiscount {
    private static final int INITIAL_DISCOUNT_AMOUNT=1000;
    private static final int ADDITIONAL_DISCOUNT_PER_DAT=100;
    private static final int START_DATE=1;
    private static final int END_DATE=25;

    public static int calculateDiscount(int day){
        if(day>=START_DATE && day<=END_DATE){
            int dayBetween=day-1;
            return INITIAL_DISCOUNT_AMOUNT+(dayBetween*ADDITIONAL_DISCOUNT_PER_DAT);
        }
        return 0;
    }
}
