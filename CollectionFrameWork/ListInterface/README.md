## List Methods

```java
import java.util.*;

public class ListMethods {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        // boolean add(E obj)
        boolean added = fruits.add("Apple");
        System.out.println("Apple added: " + added); // Output: Apple added: true

        // boolean addAll(Collection<? extends E> c)
        List<String> moreFruits = Arrays.asList("Banana", "Cherry");
        boolean addedAll = fruits.addAll(moreFruits);
        System.out.println("More fruits added: " + addedAll); // Output: More fruits added: true

        // void clear()
        List<String> tempList = new ArrayList<>(fruits);
        tempList.clear();
        System.out.println("Cleared list size: " + tempList.size()); // Output: Cleared list size: 0

        // boolean contains(Object obj)
        boolean containsApple = fruits.contains("Apple");
        System.out.println("Contains Apple: " + containsApple); // Output: Contains Apple: true

        // boolean containsAll(Collection<?> c)
        boolean containsAll = fruits.containsAll(Arrays.asList("Apple", "Banana"));
        System.out.println("Contains Apple and Banana: " + containsAll); // Output: Contains Apple and Banana: true

        // boolean equals(Object obj)
        List<String> sameList = new ArrayList<>(fruits);
        boolean isEqual = fruits.equals(sameList);
        System.out.println("Lists are equal: " + isEqual); // Output: Lists are equal: true

        // int hashCode()
        int hashCode = fruits.hashCode();
        System.out.println("HashCode: " + hashCode); // Output: HashCode: [some integer value]

        // boolean isEmpty()
        boolean isEmpty = fruits.isEmpty();
        System.out.println("List is empty: " + isEmpty); // Output: List is empty: false

        // Iterator<E> iterator()
        Iterator<String> iterator = fruits.iterator();
        System.out.print("Iterating through list: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println(); // Output: Iterating through list: Apple Banana Cherry

        // boolean remove(Object obj)
        boolean removed = fruits.remove("Banana");
        System.out.println("Banana removed: " + removed); // Output: Banana removed: true

        // boolean removeAll(Collection<?> c)
        boolean removedAll = fruits.removeAll(Arrays.asList("Apple", "Cherry"));
        System.out.println("Apple and Cherry removed: " + removedAll); // Output: Apple and Cherry removed: true

        // Add some elements back for the next examples
        fruits.addAll(Arrays.asList("Grape", "Kiwi", "Lemon"));

        // boolean retainAll(Collection<?> c)
        boolean retained = fruits.retainAll(Arrays.asList("Grape", "Orange"));
        System.out.println("Retained Grape (Orange not in list): " + retained); // Output: Retained Grape (Orange not in list): true

        // int size()
        int size = fruits.size();
        System.out.println("List size: " + size); // Output: List size: 1

        // Object[] toArray()
        Object[] array = fruits.toArray();
        System.out.println("Array contents: " + Arrays.toString(array)); // Output: Array contents: [Grape]

        // <T> T[] toArray(T array[])
        String[] stringArray = fruits.toArray(new String[0]);
        System.out.println("String array contents: " + Arrays.toString(stringArray)); // Output: String array contents: [Grape]

        // void add(int index, E obj)
        fruits.add(1, "Durian");
        System.out.println("After adding Durian at index 1: " + fruits);
        // Output: After adding Durian at index 1: [Apple, Durian, Banana, Cherry]

        // boolean addAll(int index, Collection<? extends E> c)
        boolean addedAll = fruits.addAll(2, Arrays.asList("Elderberry", "Fig"));
        System.out.println("Added Elderberry and Fig at index 2: " + addedAll);
        System.out.println("Updated list: " + fruits);
        // Output: Added Elderberry and Fig at index 2: true
        // Output: Updated list: [Apple, Durian, Elderberry, Fig, Banana, Cherry]

        // E get(int index)
        String fruit = fruits.get(3);
        System.out.println("Fruit at index 3: " + fruit);
        // Output: Fruit at index 3: Fig

        // int indexOf(Object obj)
        int bananaIndex = fruits.indexOf("Banana");
        System.out.println("Index of Banana: " + bananaIndex);
        // Output: Index of Banana: 4

        // int lastIndexOf(Object obj)
        fruits.add("Apple"); // Add another Apple to the end
        int lastAppleIndex = fruits.lastIndexOf("Apple");
        System.out.println("Last index of Apple: " + lastAppleIndex);
        // Output: Last index of Apple: 6

        // ListIterator<E> listIterator()
        ListIterator<String> listIterator = fruits.listIterator();
        System.out.print("Forward iteration: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        // Output: Forward iteration: Apple Durian Elderberry Fig Banana Cherry Apple

        // ListIterator<E> listIterator(int index)
        ListIterator<String> listIteratorFromIndex = fruits.listIterator(3);
        System.out.print("Iteration from index 3: ");
        while (listIteratorFromIndex.hasNext()) {
            System.out.print(listIteratorFromIndex.next() + " ");
        }
        System.out.println();
        // Output: Iteration from index 3: Fig Banana Cherry Apple

        // E remove(int index)
        String removedFruit = fruits.remove(2);
        System.out.println("Removed fruit at index 2: " + removedFruit);
        System.out.println("Updated list after removal: " + fruits);
        // Output: Removed fruit at index 2: Elderberry
        // Output: Updated list after removal: [Apple, Durian, Fig, Banana, Cherry, Apple]

        // E set(int index, E obj)
        String replacedFruit = fruits.set(1, "Dragonfruit");
        System.out.println("Replaced fruit at index 1: " + replacedFruit);
        System.out.println("Updated list after replacement: " + fruits);
        // Output: Replaced fruit at index 1: Durian
        // Output: Updated list after replacement: [Apple, Dragonfruit, Fig, Banana, Cherry, Apple]

        // List<E> subList(int start, int end)
        List<String> subList = fruits.subList(2, 5);
        System.out.println("Sublist from index 2 to 4: " + subList);
        // Output: Sublist from index 2 to 4: [Fig, Banana, Cherry]
    }

}
```
