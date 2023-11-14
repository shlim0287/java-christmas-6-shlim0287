package christmas.model;

public class Badge {
    private static final int STAR_THRESHOLD = 5000;
    private static final int TREE_THRESHOLD = 10000;
    private static final int SANTA_THRESHOLD = 20000;

    public static String getCategory(int totalDiscount) {
        if (isStar(totalDiscount)) {
            return "별";
        }
        if (isTree(totalDiscount)) {
            return "트리";
        }
        if (isSanta(totalDiscount)) {
            return "산타";
        }
        return "없음";
    }

    private static boolean isStar(int totalDiscount) {
        return totalDiscount >= STAR_THRESHOLD && totalDiscount < TREE_THRESHOLD;
    }

    private static boolean isTree(int totalDiscount) {
        return totalDiscount >= TREE_THRESHOLD && totalDiscount < SANTA_THRESHOLD;
    }

    private static boolean isSanta(int totalDiscount) {
        return totalDiscount >= SANTA_THRESHOLD;
    }
}
