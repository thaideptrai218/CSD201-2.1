package BT2_1;

public class Car implements Comparable<Car> {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + name + "," + price + ")";
    }

    @Override
    public int compareTo(Car o) {
        return this.price - o.price;
    }
}
