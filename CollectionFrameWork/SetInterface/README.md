# Set Methods

- All `index-based` operations `(add(int index, E element), get(int index), etc.)` are not supported because `Set` does not `maintain` an `indexed structure`.
- `ListIterator` methods are not available as they are specific to `List interface`.
- `subList` is not applicable as it's a `List-specific operation`.
- While add and `addAll` exist in `Set`, they `behave differently` than in `List`. They only add elements if they're **not** already present in the Set.
- The order of elements in a Set is not guaranteed unless we are using an implementation that maintains order (like LinkedHashSet or TreeSet).
- behavior of these methods can vary slightly depending on the specific Set implementation `(HashSet, TreeSet, LinkedHashSet, etc.)`.

```java
import java.util.*;

public class SetMethodsExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        // boolean add(E e)
        boolean added = fruits.add("Apple");
        System.out.println("Apple added: " + added); // Output: Apple added: true

        // boolean addAll(Collection<? extends E> c)
        boolean addedAll = fruits.addAll(Arrays.asList("Banana", "Cherry"));
        System.out.println("More fruits added: " + addedAll); // Output: More fruits added: true

        // void clear()
        Set<String> tempSet = new HashSet<>(fruits);
        tempSet.clear();
        System.out.println("Cleared set size: " + tempSet.size()); // Output: Cleared set size: 0

        // boolean contains(Object o)
        boolean containsApple = fruits.contains("Apple");
        System.out.println("Contains Apple: " + containsApple); // Output: Contains Apple: true

        // boolean containsAll(Collection<?> c)
        boolean containsAll = fruits.containsAll(Arrays.asList("Apple", "Banana"));
        System.out.println("Contains Apple and Banana: " + containsAll); // Output: Contains Apple and Banana: true

        // boolean equals(Object o)
        Set<String> sameSet = new HashSet<>(fruits);
        boolean isEqual = fruits.equals(sameSet);
        System.out.println("Sets are equal: " + isEqual); // Output: Sets are equal: true

        // int hashCode()
        int hashCode = fruits.hashCode();
        System.out.println("HashCode: " + hashCode); // Output: HashCode: [some integer value]

        // boolean isEmpty()
        boolean isEmpty = fruits.isEmpty();
        System.out.println("Set is empty: " + isEmpty); // Output: Set is empty: false

        // Iterator<E> iterator()
        Iterator<String> iterator = fruits.iterator();
        System.out.print("Iterating through set: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println(); // Output: Iterating through set: [elements in unspecified order]

        // boolean remove(Object o)
        boolean removed = fruits.remove("Banana");
        System.out.println("Banana removed: " + removed); // Output: Banana removed: true

        // boolean removeAll(Collection<?> c)
        boolean removedAll = fruits.removeAll(Arrays.asList("Apple", "Cherry"));
        System.out.println("Apple and Cherry removed: " + removedAll); // Output: Apple and Cherry removed: true

        // boolean retainAll(Collection<?> c)
        fruits.addAll(Arrays.asList("Grape", "Kiwi", "Lemon"));
        boolean retained = fruits.retainAll(Arrays.asList("Grape", "Orange"));
        System.out.println("Retained Grape (Orange not in set): " + retained); // Output: Retained Grape (Orange not in set): true

        // int size()
        int size = fruits.size();
        System.out.println("Set size: " + size); // Output: Set size: 1

        // Object[] toArray()
        Object[] array = fruits.toArray();
        System.out.println("Array contents: " + Arrays.toString(array)); // Output: Array contents: [Grape]

        // <T> T[] toArray(T[] a)
        String[] stringArray = fruits.toArray(new String[0]);
        System.out.println("String array contents: " + Arrays.toString(stringArray)); // Output: String array contents: [Grape]

        // Methods not applicable to Set (will throw UnsupportedOperationException if called):
        // void add(int index, E element)
        // boolean addAll(int index, Collection<? extends E> c)
        // E get(int index)
        // int indexOf(Object o)
        // int lastIndexOf(Object o)
        // ListIterator<E> listIterator()
        // ListIterator<E> listIterator(int index)
        // E remove(int index)
        // E set(int index, E element)
        // List<E> subList(int fromIndex, int toIndex)
    }
}
```
