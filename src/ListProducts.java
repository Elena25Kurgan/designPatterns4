import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListProducts implements IListProducts {
    ArrayList<IProduct> lisProducts;

    @Override
    public IListProducts addProduct(IProduct product) {
        if (lisProducts == null) {
            lisProducts = new ArrayList<>();
        }
        lisProducts.add(product);
        return this;
    }

    @Override
    public Iterator<IProduct> iterator() {
        return new Iterator<>() {
            boolean isPrimary = true;
            int nextInd = 0;

            @Override
            public boolean hasNext() {
                if (isPrimary) {
                    if (nextInd < lisProducts.size()) {
                        return true;
                    } else {
                        return !lisProducts.isEmpty();
                    }
                } else {
                    return nextInd < lisProducts.size();
                }
            }

            @Override
            public IProduct next() {
                if (isPrimary) {
                    if (nextInd < lisProducts.size()) {
                        int curIndex = nextInd;
                        nextInd++;
                        return lisProducts.get(curIndex);
                    } else {
                        isPrimary = false;
                        nextInd = 0;
                        return next();
                    }
                } else {
                    int curIndex = nextInd;
                    nextInd++;
                    return lisProducts.get(curIndex);
                }
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        lisProducts.forEach(action);
    }

    @Override
    public Spliterator<IProduct> spliterator() {
        return lisProducts.spliterator();
    }

    public IProduct findProduct(String nameProduct) {
        for (IProduct product : lisProducts) {
            if (product.getName().equals(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public IListProducts delProduct(IProduct product) {
        IProduct findProduct = findProduct(product.getName());
        if (!(findProduct == null)) {
            lisProducts.remove(findProduct);
        }
        return this;
    }

    public void removeBasket() {
        lisProducts.clear();
    }

    @Override
    public void outDisplay() {
        for (IProduct product : lisProducts) {
            System.out.println(product);
        }
    }

    @Override
    public int count() {
        return lisProducts.size();
    }
}