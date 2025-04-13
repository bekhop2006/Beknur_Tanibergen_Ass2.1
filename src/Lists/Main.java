package Lists;

public class Main {
    public static void main(String[] args) {

        // Тестирование MyArrayList
        System.out.println("MyArrayList Test:");
        MyList<String> arrayList = new MyArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        // Печать элементов MyArrayList
        printList(arrayList);

        // Тестирование MyLinkedList
        System.out.println("\nMyLinkedList Test:");
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Mouse");

        // Удаление элемента с индексом 1 (Cat)
        linkedList.remove(1);

        // Печать элементов MyLinkedList
        printList(linkedList);

        // Тестирование MyStack
        System.out.println("\nMyStack Test:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Печать результатов работы со стеком
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element (peek): " + stack.peek());

        // Тестирование MyQueue
        System.out.println("\nMyQueue Test:");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        // Печать результатов работы с очередью
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element (peek): " + queue.peek());

        // Тестирование MyMinHeap
        System.out.println("\nMyMinHeap Test:");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);

        // Печать результатов работы с мин-кучей
        System.out.println("Extracted Min: " + heap.extractMin());
        System.out.println("Min element (peek): " + heap.peek());
    }

    // Вспомогательный метод для печати содержимого списка
    public static <T> void printList(MyList<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}
