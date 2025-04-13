package Lists;

/**
 * A custom implementation of a queue (FIFO - First In, First Out).
 * Uses MyLinkedList as the underlying storage.
 *
 * Time complexity:
 * - enqueue: O(n) (linked list add is O(n))
 * - dequeue: O(1)
 * - peek: O(1)
 * - size: O(1)
 *
 * @param <T> The type of elements stored in the queue.
 */


public class MyQueue<T> {
    private MyList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.get(0);
        list.remove(0);
        return item;
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalStateException("queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
