package Lists;

/**
 * A custom implementation of a stack (LIFO - Last In, First Out).
 * Uses MyArrayList as the underlying storage.
 *
 * Time complexity:
 * - push: O(1) amortized
 * - pop: O(1)
 * - peek: O(1)
 * - size: O(1)
 *
 * @param <T> The type of elements stored in the stack.
 */


public class MyStack<T> {
    private MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty()) throw new IllegalStateException("stack is empty");
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalStateException("stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
