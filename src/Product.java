public class Product implements IProduct {
    private static int kol = 0;
    private int num;
    private String name;
    private String type;
    private double price;

    public Product(String name, String type, double price) {
        kol++;
        this.num = kol;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getNum() {
        return num;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getNum() + ". " + getName() + " " + getPrice() + "руб/шт";
    }
}
