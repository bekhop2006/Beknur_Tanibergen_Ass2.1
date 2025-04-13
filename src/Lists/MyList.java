package Lists;
import java.util.Iterator;
/**
 * A generic list interface defining basic list operations.
 *
 * @param <T> The type of elements in the list.
 */


public interface MyList<T> extends Iterable<T> {
    void add(T element);
    void add(int index, T element);
    void remove(int index);
    boolean remove(T element);
    T get(int index);
    int size();
    boolean isEmpty();
    void clear();
    Iterator<T> iterator();
}

