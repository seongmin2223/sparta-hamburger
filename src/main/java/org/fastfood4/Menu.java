package org.fastfood4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu(String categoryName) throws Exception {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();

        switch (categoryName) {
            case "Burgers":
                menuItems.add(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                menuItems.add(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                menuItems.add(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                menuItems.add(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));
                break;
            case "Drinks":
            case "Desserts":
                break;
            default:
                throw new Exception("잘못입력하셨어요.");
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void displayMenuItems() {
        System.out.println("\n[ " + categoryName + " MENU ]\n");
        if (menuItems.isEmpty()) {
            System.out.println("해당 메뉴는 아직 준비되지 않았어요.");
        } else {
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
            }
        }
        System.out.println("0. 뒤로가기");
    }
}