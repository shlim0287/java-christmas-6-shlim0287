package christmas.utils;

import christmas.model.OrderItem;
import christmas.model.OrderItems;
import christmas.model.menu.MenuItem;
import java.util.List;
import java.util.StringTokenizer;

public class MenuOrderParser {

    OrderItems orderItems= new OrderItems();

    public  List<OrderItem> parseMenuOrder(String input){
        StringTokenizer tokenizer = splitByComma(input);
        while(tokenizer.hasMoreTokens()){
            StringTokenizer order = splitByBar(tokenizer);
            String menuName = order.nextToken();
            int quantity = Integer.parseInt(order.nextToken());
            MenuItem existingMenuItem=orderItems.findMenuItemByName(menuName);

            if(existingMenuItem !=null){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            for(MenuItem menuItem : MenuItem.values()){
                if(isMatchName(menuName, menuItem)){
                    orderItems.addOrder(new OrderItem(menuItem,quantity));
                }
                if(!isMatchName(menuName,menuItem)){
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                }
            }
        }
        return orderItems.getOrderItems();
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
}
