# NavigableSet Methods

```java
import java.util.*;

public class NavigableSetMethodsExample {
    public static void main(String[] args) {
        NavigableSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));

        System.out.println("Original NavigableSet: " + numbers);

        // E ceiling(E obj)
        // Throws NullPointerException if the specified element is null and this set uses natural ordering or a comparator that does not permit null elements
        Integer ceiling = numbers.ceiling(6);
        System.out.println("Ceiling of 6: " + ceiling); // Output: Ceiling of 6: 7

        // Iterator<E> descendingIterator()
        System.out.print("Descending order: ");
        numbers.descendingIterator().forEachRemaining(n -> System.out.print(n + " "));
        System.out.println();

        // NavigableSet<E> descendingSet()
        NavigableSet<Integer> descending = numbers.descendingSet();
        System.out.println("Descending set: " + descending);

        // E floor(E obj)
        // Throws NullPointerException if the specified element is null and this set uses natural ordering or a comparator that does not permit null elements
        Integer floor = numbers.floor(6);
        System.out.println("Floor of 6: " + floor); // Output: Floor of 6: 5

        // NavigableSet<E> headSet(E upperBound, boolean incl)
        // Throws NullPointerException if upperBound is null and this set uses natural ordering or a comparator that does not permit null elements
        // Throws IllegalArgumentException if this set is unbounded and upperBound is not comparable with the set's elements
        NavigableSet<Integer> headSet = numbers.headSet(8, true);
        System.out.println("HeadSet up to 8 (inclusive): " + headSet);

        // E higher(E obj)
        // Throws NullPointerException if the specified element is null and this set uses natural ordering or a comparator that does not permit null elements
        Integer higher = numbers.higher(7);
        System.out.println("Higher than 7: " + higher); // Output: Higher than 7: 9

        // E lower(E obj)
        // Throws NullPointerException if the specified element is null and this set uses natural ordering or a comparator that does not permit null elements
        Integer lower = numbers.lower(7);
        System.out.println("Lower than 7: " + lower); // Output: Lower than 7: 5

        // E pollFirst()
        Integer first = numbers.pollFirst();
        System.out.println("Polled first element: " + first);
        System.out.println("Set after polling first: " + numbers);

        // E pollLast()
        Integer last = numbers.pollLast();
        System.out.println("Polled last element: " + last);
        System.out.println("Set after polling last: " + numbers);

        // NavigableSet<E> subSet(E lowerBound, boolean lowIncl, E upperBound, boolean highIncl)
        // Throws NullPointerException if lowerBound or upperBound is null and this set uses natural ordering or a comparator that does not permit null elements
        // Throws IllegalArgumentException if lowerBound is greater than upperBound, or if this set is unbounded and lowerBound or upperBound is not comparable with the set's elements
        NavigableSet<Integer> subSet = numbers.subSet(5, true, 11, false);
        System.out.println("Subset from 5 (inclusive) to 11 (exclusive): " + subSet);

        // NavigableSet<E> tailSet(E lowerBound, boolean incl)
        // Throws NullPointerException if lowerBound is null and this set uses natural ordering or a comparator that does not permit null elements
        // Throws IllegalArgumentException if this set is unbounded and lowerBound is not comparable with the set's elements
        NavigableSet<Integer> tailSet = numbers.tailSet(9, false);
        System.out.println("TailSet from 9 (exclusive): " + tailSet);

        // Demonstrating exception
        try {
            numbers.ceiling(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException when passing null to ceiling(): " + e.getMessage());
        }
    }
}
```

- Most methods that take an element as a parameter `(like ceiling, floor, higher, lower)` can throw a `NullPointerException` if the element is null and the set doesn't permit null elements.
- Methods that deal with ranges `(headSet, tailSet, subSet)` can throw `IllegalArgumentException` if the bounds are not consistent with the set's ordering.
- `pollFirst()` and `pollLast()` **modify** the set by `removing` the **returned** element.
- The `descendingSet()` and the sets returned by `headSet()`, `tailSet()`, and `subSet()` are views backed by the original set. Changes to these views are `reflected` in the `original set` and vice versa.
- The `descendingIterator()` provides a way to `iterate` over the set in `reverse` order **without creating** a `new set`.
- Actual behavior might vary slightly depending on the specific implementation of NavigableSet used above. TreeSet, which we used in this example, does not allow null elements, so operations with null will always throw a NullPointerException
