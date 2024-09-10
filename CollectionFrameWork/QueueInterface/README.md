# Queue Methods

- This example demonstrates all the methods available in the Queue interface, including those inherited from the Collection interface. Here are some key points:
- `add(E e)` and `offer(E e)` both add elements to the `queue`, but `add()` throws an `exception` if the queue is `capacity-restricted and full`, while `offer()` returns `false`.
- `element()` and `peek()` both return the `head` of the queue without `removing it`, but `element()` throws an `exception` if the queue is `empty`, while `peek()` returns `null`.
- `remove()` and `poll()` both `remove` and `return` the `head` of the queue, but `remove()` throws an `exception` if the queue is `empty`, while `poll()` returns `null`.
- The `order` of elements in a queue depends on the `specific implementation`. `LinkedList`, which we used here, maintains `insertion order`.
- Some methods like `addAll()`, `removeAll()`, and `retainAll()` are inherited from the `Collection` interface and might not be `optimized` for `queue operations`.
The `iterator()` method provides a way to `iterate` over the elements of the queue **without** `removing` them.
- `LinkedList` as Queue implementation in this example.

```java
import java.util.*;

public class QueueMethodsExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // boolean add(E e)
        // Throws IllegalStateException if the element cannot be added due to capacity restrictions
        try {
            boolean added = queue.add("Apple");
            System.out.println("Apple added: " + added);
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element: " + e.getMessage());
        }

        queue.add("Banana");
        queue.add("Cherry");

        // E element()
        // Throws NoSuchElementException if the queue is empty
        try {
            String head = queue.element();
            System.out.println("Head of queue (element): " + head);
        } catch (NoSuchElementException e) {
            System.out.println("Queue is empty: " + e.getMessage());
        }

        // boolean offer(E e)
        boolean offered = queue.offer("Date");
        System.out.println("Date offered: " + offered);

        // E peek()
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);

        // E poll()
        String polled = queue.poll();
        System.out.println("Polled element: " + polled);
        System.out.println("Queue after poll: " + queue);

        // E remove()
        // Throws NoSuchElementException if the queue is empty
        try {
            String removed = queue.remove();
            System.out.println("Removed element: " + removed);
        } catch (NoSuchElementException e) {
            System.out.println("Failed to remove element: " + e.getMessage());
        }

        // Additional methods inherited from Collection interface:

        // boolean addAll(Collection<? extends E> c)
        boolean addedAll = queue.addAll(Arrays.asList("Elderberry", "Fig"));
        System.out.println("Added all: " + addedAll);

        // void clear()
        Queue<String> tempQueue = new LinkedList<>(queue);
        tempQueue.clear();
        System.out.println("Cleared queue size: " + tempQueue.size());

        // boolean contains(Object o)
        boolean containsCherry = queue.contains("Cherry");
        System.out.println("Contains Cherry: " + containsCherry);

        // boolean containsAll(Collection<?> c)
        boolean containsAll = queue.containsAll(Arrays.asList("Cherry", "Date"));
        System.out.println("Contains Cherry and Date: " + containsAll);

        // boolean isEmpty()
        boolean isEmpty = queue.isEmpty();
        System.out.println("Queue is empty: " + isEmpty);

        // Iterator<E> iterator()
        System.out.print("Iterating through queue: ");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // boolean remove(Object o)
        boolean removed = queue.remove("Fig");
        System.out.println("Fig removed: " + removed);

        // boolean removeAll(Collection<?> c)
        boolean removedAll = queue.removeAll(Arrays.asList("Cherry", "Date"));
        System.out.println("Cherry and Date removed: " + removedAll);

        // boolean retainAll(Collection<?> c)
        boolean retained = queue.retainAll(Arrays.asList("Elderberry", "Grape"));
        System.out.println("Retained Elderberry (Grape not in queue): " + retained);

        // int size()
        int size = queue.size();
        System.out.println("Queue size: " + size);

        // Object[] toArray()
        Object[] array = queue.toArray();
        System.out.println("Array contents: " + Arrays.toString(array));

        // <T> T[] toArray(T[] a)
        String[] stringArray = queue.toArray(new String[0]);
        System.out.println("String array contents: " + Arrays.toString(stringArray));
    }
}
```
