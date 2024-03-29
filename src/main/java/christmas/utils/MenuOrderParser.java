package christmas.utils;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.menu.MenuItem;
import java.util.List;
import java.util.StringTokenizer;

public class MenuOrderParser {

    OrderItems orderItems= new OrderItems();

    public  OrderItems parseMenuOrder(String input){
        StringTokenizer tokenizer = splitByComma(input);
        while(tokenizer.hasMoreTokens()){
            StringTokenizer order = splitByBar(tokenizer);
            String menuName = order.nextToken();
            int quantity = Integer.parseInt(order.nextToken());
            validateMenuCountZero(quantity);
            validateDuplicationMenu(menuName);
            addOrderToOrderListIfValid(menuName, quantity);
        }
        return orderItems;
    }

    private static void validateMenuCountZero(int quantity) {
        if(quantity ==0){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void addOrderToOrderListIfValid(String menuName, int quantity) {
        MenuItem specificMenuItem = findMenuItemByName(menuName);
        if (specificMenuItem != null) {
            validateUniqueMenu(menuName, specificMenuItem);
            addOrderToOrderList(menuName, quantity, specificMenuItem);
        }
        validateMenuName(specificMenuItem);
    }

    private static void validateMenuName(MenuItem specificMenuItem) {
        if(specificMenuItem ==null){
            throw new IllegalArgumentException("[ERROR] 주문한 메뉴를 찾을 수 없습니다.");
        }
    }

    private void addOrderToOrderList(String menuName, int quantity, MenuItem menuItem) {
        if(isMatchName(menuName, menuItem)){
            orderItems.addOrder(new OrderItem(menuItem, quantity));
        }
    }

    private static void validateUniqueMenu(String menuName, MenuItem menuItem) {
        if(!isMatchName(menuName, menuItem)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateDuplicationMenu(String menuName) {
        MenuItem existingMenuItem=orderItems.findMenuItemByName(menuName);

        if(existingMenuItem !=null){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isMatchName(String menuName, MenuItem menuItem) {
        return menuItem.getMenuName().equals(menuName);
    }

    private StringTokenizer splitByBar(StringTokenizer tokenizer) {
        StringTokenizer order = new StringTokenizer(tokenizer.nextToken(), "-");
        return order;
    }

    private StringTokenizer splitByComma(String input) {
        StringTokenizer tokenizer=new StringTokenizer(input,",");
        return tokenizer;
    }

    private MenuItem findMenuItemByName(String menuName) {
        for (MenuItem menuItem : MenuItem.values()) {
            if (isMatchName(menuName, menuItem)) {
                return menuItem;
            }
        }
        return null;
    }
}
