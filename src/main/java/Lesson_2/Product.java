package Lesson_2;

public class Product {

    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void showInfo() {
        System.out.println(name + " " + price + " у.е.");
    }
}