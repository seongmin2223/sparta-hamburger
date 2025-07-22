package org.fastfood4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName; // 메뉴 카테고리 이름 (예: "Burgers", "Drinks")
    private List<MenuItem> menuItems; // 이 카테고리에 속하는 MenuItem 객체들을 관리하는 리스트

    // 생성자: 메뉴 카테고리 이름을 받아 초기화하고, 해당 카테고리의 MenuItem들을 바로 추가합니다.
    public Menu(String categoryName) throws Exception {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>(); // MenuItem 리스트 초기화

        // 생성자 내부에서 카테고리에 따라 다른 MenuItem들을 추가합니다.
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

    // 메뉴 카테고리 이름을 반환하는 메서드
    public String getCategoryName() {
        return categoryName;
    }

    // 이 카테고리의 MenuItem 리스트를 반환하는 메서드
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void displayMenuItems() {
        System.out.println("\n[ " + categoryName + " MENU ]\n"); // [ BURGERS MENU ]

        // menuItems 리스트가 비어있으면 준비되지 않은 메뉴 메시지를 출력합니다.
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