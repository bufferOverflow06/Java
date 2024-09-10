# Deque Methods

- Methods that add elements `(addFirst, addLast, push)` can throw `IllegalStateException` if the deque is `capacity-restricted and full`.
- Methods that retrieve but don't remove elements `(getFirst, getLast, element)` throw `NoSuchElementException` if the deque is empty.
- Methods that remove elements `(removeFirst, removeLast, pop, remove)` throw `NoSuchElementException` if the deque is empty.
- Methods with `offer`, `peek`, and `poll` in their names don't throw exceptions for capacity restrictions or when the deque is empty. Instead, they `return special` values (`false` or `null`).
- The `descendingIterator()` method doesn't throw any exceptions itself, but the `next()` method of the returned iterator can throw `NoSuchElementException` if there are no more elements.
- Methods like `removeFirstOccurrence` and `removeLastOccurrence` don't throw exceptions if the element is not found; they simply return false.
- Actual behavior might vary slightly depending on the specific implementation of Deque used here. Some implementations might be bounded (have a maximum capacity) while others (like LinkedList) are unbounded.

- `LinkedList` as Deque implementation
```java
import java.util.*;

public class DequeMethodsExample {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // Methods inherited from Queue interface

        // boolean add(E e)
        // Throws IllegalStateException if the element cannot be added due to capacity restrictions
        try {
            boolean added = deque.add("Apple");
            System.out.println("Apple added: " + added);
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element: " + e.getMessage());
        }

        // boolean offer(E e)
        boolean offered = deque.offer("Banana");
        System.out.println("Banana offered: " + offered);

        // E remove()
        // Throws NoSuchElementException if the deque is empty
        try {
            String removed = deque.remove();
            System.out.println("Removed element: " + removed);
        } catch (NoSuchElementException e) {
            System.out.println("Failed to remove element: " + e.getMessage());
        }

        // E poll()
        String polled = deque.poll();
        System.out.println("Polled element: " + polled);

        // E element()
        // Throws NoSuchElementException if the deque is empty
        try {
            String element = deque.element();
            System.out.println("Element at head: " + element);
        } catch (NoSuchElementException e) {
            System.out.println("Deque is empty: " + e.getMessage());
        }

        // E peek()
        String peeked = deque.peek();
        System.out.println("Peeked element: " + peeked);

        // Additional Deque methods

        // void addFirst(E e)
        // Throws IllegalStateException if the element cannot be added due to capacity restrictions
        try {
            deque.addFirst("Cherry");
            System.out.println("Cherry added to front");
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element to front: " + e.getMessage());
        }

        // void addLast(E e)
        // Throws IllegalStateException if the element cannot be added due to capacity restrictions
        try {
            deque.addLast("Date");
            System.out.println("Date added to back");
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element to back: " + e.getMessage());
        }

        // Iterator<E> descendingIterator()
        System.out.print("Descending order: ");
        Iterator<String> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();

        // E getFirst()
        // Throws NoSuchElementException if the deque is empty
        try {
            String first = deque.getFirst();
            System.out.println("First element: " + first);
        } catch (NoSuchElementException e) {
            System.out.println("Deque is empty: " + e.getMessage());
        }

        // E getLast()
        // Throws NoSuchElementException if the deque is empty
        try {
            String last = deque.getLast();
            System.out.println("Last element: " + last);
        } catch (NoSuchElementException e) {
            System.out.println("Deque is empty: " + e.getMessage());
        }

        // boolean offerFirst(E e)
        boolean offeredFirst = deque.offerFirst("Elderberry");
        System.out.println("Elderberry offered to front: " + offeredFirst);

        // boolean offerLast(E e)
        boolean offeredLast = deque.offerLast("Fig");
        System.out.println("Fig offered to back: " + offeredLast);

        // E peekFirst()
        String peekFirst = deque.peekFirst();
        System.out.println("Peeked first element: " + peekFirst);

        // E peekLast()
        String peekLast = deque.peekLast();
        System.out.println("Peeked last element: " + peekLast);

        // E pollFirst()
        String pollFirst = deque.pollFirst();
        System.out.println("Polled first element: " + pollFirst);

        // E pollLast()
        String pollLast = deque.pollLast();
        System.out.println("Polled last element: " + pollLast);

        // E pop()
        // Throws NoSuchElementException if the deque is empty
        try {
            String popped = deque.pop();
            System.out.println("Popped element: " + popped);
        } catch (NoSuchElementException e) {
            System.out.println("Failed to pop element: " + e.getMessage());
        }

        // void push(E e)
        // Throws IllegalStateException if the element cannot be added due to capacity restrictions
        try {
            deque.push("Grape");
            System.out.println("Grape pushed to front");
        } catch (IllegalStateException e) {
            System.out.println("Failed to push element: " + e.getMessage());
        }

        // E removeFirst()
        // Throws NoSuchElementException if the deque is empty
        try {
            String removedFirst = deque.removeFirst();
            System.out.println("Removed first element: " + removedFirst);
        } catch (NoSuchElementException e) {
            System.out.println("Failed to remove first element: " + e.getMessage());
        }

        // boolean removeFirstOccurrence(Object o)
        boolean removedFirstOccurrence = deque.removeFirstOccurrence("Cherry");
        System.out.println("Removed first occurrence of Cherry: " + removedFirstOccurrence);

        // E removeLast()
        // Throws NoSuchElementException if the deque is empty
        try {
            String removedLast = deque.removeLast();
            System.out.println("Removed last element: " + removedLast);
        } catch (NoSuchElementException e) {
            System.out.println("Failed to remove last element: " + e.getMessage());
        }

        // boolean removeLastOccurrence(Object o)
        boolean removedLastOccurrence = deque.removeLastOccurrence("Date");
        System.out.println("Removed last occurrence of Date: " + removedLastOccurrence);

        System.out.println("Final deque: " + deque);
    }
}
```
