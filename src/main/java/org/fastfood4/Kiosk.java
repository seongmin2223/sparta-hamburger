package org.fastfood4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> mainMenus;
    private Scanner scanner;

    public Kiosk() throws Exception {
        this.mainMenus = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeMenus();
    }

    private void initializeMenus() throws Exception {
        mainMenus.add(new Menu("Burgers"));
        mainMenus.add(new Menu("Drinks"));
        mainMenus.add(new Menu("Desserts"));
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int mainChoice = getUserInput();

            if (mainChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (mainChoice > 0 && mainChoice <= mainMenus.size()) {
                Menu selectedCategory = mainMenus.get(mainChoice - 1);
                handleCategorySelection(selectedCategory);
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < mainMenus.size(); i++) {
            System.out.println((i + 1) + ". " + mainMenus.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 종료");
        System.out.print("선택: ");
    }

    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            System.out.print("선택: ");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private void handleCategorySelection(Menu category) {
        category.displayMenuItems();

        // 메뉴 아이템 리스트가 비어있으면 (준비되지 않은 메뉴라면)
        if (category.getMenuItems().isEmpty()) {
            System.out.println();
            return;
        }

        System.out.print("선택: ");
        int itemChoice = getUserInput();

        if (itemChoice == 0) {
            return;
        }

        if (itemChoice > 0 && itemChoice <= category.getMenuItems().size()) {
            MenuItem selectedItem = category.getMenuItems().get(itemChoice - 1);
            // 여기도 println으로 변경
            System.out.println("\n선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
        } else {
            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }
    }
}