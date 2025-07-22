package org.fastfood4;

public class MenuItem {

    private String name;
    private String description;
    private String price;

    public MenuItem(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // 필드 값에 접근하기 위한 Getter 메소드들
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


}
