package christmas.model.menu;

import christmas.model.menu.MenuType;

public enum MenuItem {
    MUSHROOM_SOUP(MenuType.APPETIZER,"양송이수프",6000),
    TAPAS(MenuType.APPETIZER,"타파스",5500),
    CAESAR_SALAD(MenuType.APPETIZER,"시저샐러드",8000),

    T_BONE_STEAK(MenuType.MAIN,"티본스테이크",55000),
    BBQ_RIB(MenuType.MAIN,"바비큐립",54000),
    SEAFOOD_PASTA(MenuType.MAIN,"해산물파스타",35000),
    CHRISTMAS_PASTA(MenuType.MAIN,"크리스마스파스타",25000),

    CHOCO_CAKE(MenuType.DESSERT,"초코케이크",15000),
    ICE_CREAM(MenuType.DESSERT,"아이스크림",5000),

    ZERO_COLA(MenuType.BEVERAGE,"제로콜라",3000),
    RED_WINE(MenuType.BEVERAGE,"레드와인",60000),
    CHAMPAGNE(MenuType.BEVERAGE,"샴페인",25000);

    private final MenuType menuType;
    private final String menuName;
    private final int price;

    MenuItem(MenuType menuType, String menuName, int price) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.price = price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }
}
