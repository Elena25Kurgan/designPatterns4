import java.util.*;
import java.util.stream.Collectors;

public class StoreProducts extends ListProducts {

    public StoreProducts() {}
    public StoreProducts(ArrayList<IProduct> store) {
        lisProducts = store;
    }

    @Override
    public StoreProducts addProduct(IProduct product) {
        if (lisProducts == null) {lisProducts = new ArrayList<>();}
        lisProducts.add(product);
        return this;
    }

    public IProduct findIdProduct(int numProduct) {
        for (IProduct product: lisProducts) {
            if (product.getNum() == numProduct) {
                return product;
            }
        }
        return null;
    }

    public StoreProducts filter(String typeProducts) {
        List<IProduct> filteredList = lisProducts.stream()
                .filter(product -> product.getType().equals(typeProducts))
                .collect(Collectors.toList());
        ArrayList<IProduct> filteredStore = new ArrayList<>(filteredList);
        return new StoreProducts(filteredStore);
    }
}