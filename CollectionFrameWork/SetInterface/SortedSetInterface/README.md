# SortedSet Methods

- TreeSet, which is an implementation of SortedSet.

```java
import java.util.*;

public class SortedSetMethodsExample {
    public static void main(String[] args) {
        SortedSet<String> fruits = new TreeSet<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig"));

        System.out.println("Original SortedSet: " + fruits);

        // E first()
        String firstFruit = fruits.first();
        System.out.println("First fruit: " + firstFruit);
        // Output: First fruit: Apple

        // E last()
        String lastFruit = fruits.last();
        System.out.println("Last fruit: " + lastFruit);
        // Output: Last fruit: Fig

        // SortedSet<E> subSet(E fromElement, E toElement)
        SortedSet<String> subSet = fruits.subSet("Banana", "Elderberry");
        System.out.println("Subset from Banana to Elderberry (exclusive): " + subSet);
        // Output: Subset from Banana to Elderberry (exclusive): [Banana, Cherry, Date]

        // SortedSet<E> headSet(E toElement)
        SortedSet<String> headSet = fruits.headSet("Date");
        System.out.println("HeadSet before Date: " + headSet);
        // Output: HeadSet before Date: [Apple, Banana, Cherry]

        // SortedSet<E> tailSet(E fromElement)
        SortedSet<String> tailSet = fruits.tailSet("Date");
        System.out.println("TailSet from Date: " + tailSet);
        // Output: TailSet from Date: [Date, Elderberry, Fig]

        // Comparator<? super E> comparator()
        Comparator<? super String> comparator = fruits.comparator();
        System.out.println("Comparator used: " + (comparator == null ? "Natural ordering" : comparator));
        // Output: Comparator used: Natural ordering

        // Additional examples to show behavior
        try {
            fruits.subSet("Fig", "Banana");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception when fromElement > toElement: " + e.getMessage());
        }

        // Using subSet with range that includes elements not in the set
        SortedSet<String> extendedSubSet = fruits.subSet("Blueberry", "Grape");
        System.out.println("Subset from Blueberry to Grape: " + extendedSubSet);
        // Output: Subset from Blueberry to Grape: [Cherry, Date, Elderberry, Fig]
    }
}
```

- `first()`: Returns the first (lowest) element in the set.
- `last()`: Returns the last (highest) element in the set.
- `subSet(E fromElement, E toElement)`: Returns a view of the portion of the set between fromElement (inclusive) and toElement (exclusive).
- `headSet(E toElement)`: Returns a view of the portion of the set whose elements are strictly less than toElement.
- `tailSet(E fromElement)`: Returns a view of the portion of the set whose elements are greater than or equal to fromElement.
- `comparator()`: Returns the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements.

### Key points to note:

- The `SortedSet` maintains its elements in sorted order.
- The `subSet`, `headSet`, and `tailSet` methods return views of the `original set`. `Changes` to these views are `reflected` in the `original set` and vice versa.
- If you try to `create` a subset where the `fromElement` is `greater` than the `toElement`, it will throw an `IllegalArgumentException`.
- When using `subSet`, `headSet`, or `tailSet` with elements not present in the set, it still works based on the `natural ordering` (or the set's comparator).
