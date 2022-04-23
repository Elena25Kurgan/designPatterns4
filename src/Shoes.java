public class Shoes extends Product {
    int size;


    public Shoes(String name, String type, double price, int size) {
        super(name,type,price);
        this.size = size;
    }

    @Override
    public String toString() {
        return getNum() + ". " + getName() + " " + getPrice() + "руб/шт размера " + size;
    }
}
