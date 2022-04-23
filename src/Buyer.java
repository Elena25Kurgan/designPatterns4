public class Buyer {
    private final int MAX_PRODUCTS = 10;
    private final String fio;

    private ListProducts basket;

    public Buyer(String fio) {
        this.fio = fio;
    }

    public void addBasket (IProduct product) {
        if (basket == null) {basket = new ListProducts();}
        basket.addProduct(product);
        if (basket.count() > MAX_PRODUCTS) {
            System.out.println("Количество продуктов в корзине не может быть больше " + MAX_PRODUCTS);
        } else {
            System.out.println(product.getName() + " добвавлен в корзину");
        }
        basket.outDisplay();
    }

    public void delBasket (IProduct product) {
        basket.delProduct(product);
        System.out.println(product.getName() + " удален из корзины");
        basket.outDisplay();
    }

    public void removeBasket () {
        basket.removeBasket();
    }
}
