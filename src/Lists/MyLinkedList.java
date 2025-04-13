package Lists;

import java.util.Iterator;

/**
 * A custom implementation of a singly linked list.
 * Elements are stored in nodes, each pointing to the next one.
 *
 * Time complexity:
 * - add: O(n) (traverse to end)
 * - get: O(n)
 * - remove: O(n)
 * - clear: O(1)
 * - size: O(1)
 *
 * @param <T> The type of elements stored in the list.
 */


public class MyLinkedList<T> implements MyList<T> {

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = tail = null;
        length = 0;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> newNode = new MyNode<>(item);

        if (index == length) {
            add(item);
            return;
        } else if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> previous = current.prev;
            newNode.next = current;
            newNode.prev = previous;

            if (previous != null) {
                previous.next = newNode;
            }
            current.prev = newNode;

            if (index == 0) {
                head = newNode;
            }
        }

        length++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current;
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> toRemove = getNode(index);

        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;

        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;

        length--;
    }

    public boolean remove(T item) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(item)) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }



    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
