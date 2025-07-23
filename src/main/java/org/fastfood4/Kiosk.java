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
        int input = -1;
        boolean isValidInput = false;

        while (!isValidInput) { // 유효한 입력이 들어올 때까지 반복
            String line = scanner.nextLine(); // 사용자 입력을 한 줄 전체(문자열)로 읽어옴

            try {
                input = Integer.parseInt(line); // 읽어온 문자열을 정수로 변환 시도
                isValidInput = true; // 변환 성공 시 유효한 입력으로 간주
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 문자열(예: "abc", "안녕")이 들어오면 이 블록 실행
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                // isValidInput은 여전히 false이므로, 루프가 다시 시작되어 재입력 요청
            }
        }
        return input; // 유효한 숫자 입력 반환
    }

    private void handleCategorySelection(Menu category) {
        category.displayMenuItems();
        if (category.getMenuItems().isEmpty()) {
            return;
        }
        System.out.print("선택: ");
        int itemChoice = getUserInput();
        if (itemChoice == 0) {
            return;
        }
        if (itemChoice > 0 && itemChoice <= category.getMenuItems().size()) {
            MenuItem selectedItem = category.getMenuItems().get(itemChoice - 1);
            System.out.println("\n선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
        } else {
            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }
    }
}