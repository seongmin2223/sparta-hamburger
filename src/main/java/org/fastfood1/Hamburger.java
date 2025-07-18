package org.fastfood1;

import java.util.Scanner;

public class Hamburger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("아래메뉴중 하나의 번호를 입력해주세요\n\n" +
                    "[ SHAKESHACK MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료\n\n" +
                    "(메뉴를 선택해주세요.) : ");
            String input = scanner.nextLine().trim();

            // "0"이 입력되면 프로그램 종료
            if (input.equalsIgnoreCase("0")) {
                System.out.println("메뉴주문을 종료합니다.");
                return;
            }

            int menuNumber;

            try {
                // 첫 번째 입력으로 받은 문자열을 정수로 변환 시도
                menuNumber = Integer.parseInt(input);

            } catch (NumberFormatException e) {
                // 숫자가 아닌 입력을 받았을 때 처리
                System.out.println("오류: 잘못된 숫자 입력입니다. 다시 시도해주세요.");
                continue; // 다시 반복 시작
            }

            // switch 문을 사용하여 연산 기호에 따른 계산 수행
            switch (menuNumber) {
                case 1:
                    System.out.println("\n1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2:
                    System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3:
                    System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4:
                    System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
                case 0:
                    System.out.println("종료되었습니다.");
                    break;
            }
            System.out.println(); // 다음 계산을 위해 줄 바꿈
        }
    }

}