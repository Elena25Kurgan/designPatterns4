import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public interface IListProducts extends Iterable<IProduct>{
    IListProducts addProduct(IProduct product);
    int count();
    IProduct findProduct(String product);
    Iterator<IProduct> iterator();
    void forEach(Consumer action);
    Spliterator<IProduct> spliterator();
    void outDisplay();
}
