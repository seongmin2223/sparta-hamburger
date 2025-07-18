package org.fastfood3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<MenuItem> menuItems;
    private Scanner scanner;

    public Kiosk(List<MenuItem> initMenu) {
        this.menuItems = initMenu;
        this.scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        while (true) {
            System.out.print("아래메뉴중 하나의 번호를 입력해주세요");
            System.out.println("[ SHAKESHACK MENU ]");

            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
            }
            System.out.println("0. 종료\n");

            System.out.println("메뉴를 선택해주세요 : ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("메뉴주문을 종료합니다.");
                break;
            }

            int menuNumber;

            try {
                menuNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("숫자만 입력해주세요");
            }

            if (menuNumber >= 1 && menuNumber <= menuItems.size()) {
                MenuItem selectedItem = menuItems.get(menuNumber - 1);
                System.out.println("\n--- 선택하신 메뉴 ---");
                System.out.println("이름: " + selectedItem.getName());
                System.out.println("가격: W " + selectedItem.getPrice());
                System.out.println("설명: " + selectedItem.getDescription());
                System.out.println("--------------------");
            } else {
                throw new Exception("존재하지않는 번호입니다. \n");
            }
        }
    }

}
