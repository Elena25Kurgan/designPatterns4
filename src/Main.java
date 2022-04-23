import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StoreProducts products = new StoreProducts()
                .addProduct(new Product("Хлеб", "Продукты",100))
                .addProduct(new Product("Яблоки","Продукты",200))
                .addProduct(new Product("Кофта","Одежда",3000))
                .addProduct(new Shoes("Кросовки","Обувь",4000, 48))
                .addProduct(new Product("Сыр","Продукты",250));

        Buyer buyer = new Buyer("Иванов Иван");
        System.out.println("Список возможных товаров для покупки:");
        System.out.println("1. Показать список товаров");
        System.out.println("2. Фильтрация списка по типу товара");
        System.out.println("3. Добавить товар в корзину");
        System.out.println("4. Убрать товар из корзинны");
        System.out.println("5. Совершить покупку");

        while (true) {
            System.out.println("Выберите действие или введите `end`");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }
            int numAct = Integer.parseInt(input);

            switch (numAct) {
                case  (1):
                    products.outDisplay();
                    break;
                case (2):
                    String typeProducts = "Продукты";
                    products.filter(typeProducts).outDisplay();
                    break;
                case (3):
                    System.out.println("Введите номер товара:");
                    int numProduct = Integer.parseInt(scanner.nextLine());
                    buyer.addBasket(products.findIdProduct(numProduct));
                    break;
                case (4):
                    System.out.println("Введите номер товара:");
                    int numDelProduct = Integer.parseInt(scanner.nextLine());
                    buyer.delBasket(products.findIdProduct(numDelProduct));
                    break;
                case (5):
                    buyer.removeBasket();
                    break;
                default:
                    System.out.println("Вы неправильно выбрали действие");
                    break;
            }
        }
    }
}
