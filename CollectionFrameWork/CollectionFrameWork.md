# Collection Interfaces

| Interface   | Description|
|--------------- | --------------- |
| Collection   | Enables to work with groups of objects; it is at the top of the collections hierarachy  |
| Deque   | Extends `Queue` to handle a double-ended queue   |
| List   | Extends `Collection` to handle sequences (lists of objects).  |
| NavigableSet   | Extends `SortedSet` to handle retrieval of elements based on closest-match search.   |
| Queue   | Extends `Collection` to handle special types of lists in which elements are removed only from the head.   |
| Set   | Extends `Collection` to handle sets, which must contain unique elements.   |
| SortedSet   | Extends `Set` to handle sorted sets.   |

- `Comparators`
    - defines how two objects are compared
`RandomAccess`
    - by implementing `RandomAccess`, a list indicates that is supports efficient, random access to its elements. 
- `Iterator` & `ListIterator`
    - enumerate the objects within a collection

- To provide the greatest flexibility in their use, the collection interfaces allow some methods to be optional. The optional methods enable you to modify the contents of a collection. Collections that support these methods are called `modifiable`. Collections that do not allow their contents to be changed are called `unmodifiable`. 
- If an attempt is made to use one of these methods on an `unmodifiable` collection, an `UnsupportedOperationException` is thrown. 
- All the built-in collections are modifiable.


- The `Collection` interface is the foundation upon which the `Collection Framework` is built because it must be implemented by any class that defines a collection. `Collection` is a `generic interface` that has this declaration
    - `inteface Collection<E>`
    - Here, `E` specifies the type of objects that the collection will hold. `Collection` extends the `Iterable` interface. This means that all collections can be cycled through by use of the `for-each` style for loop.

- Several `methods` in collection framework can throw these `exceptions`
    1) `UnsupportedOperationException` - this occurs if a collection cannot be modified.
    2) `ClassCastException` - generated when one object is incompatible with another, such as when an attempt is made to store a `null` object and `null` elements are not allowed in the `collection`. 
    3) `IllegalArgumentException` - is thrown if an invalid argument is used.
    4) `NullPointerException` - is thrown if and attempt is made to store a `null` object and null elements are not allowed in the collection.
    5) `IllegalStateException` - is thrown if an attempt is made to add an element to a fixed-length collection that is full.

- Some methods which are `frequently` used

| Methods   | Description |
|--------------- | --------------- |
| `add()`   | Objects are added to a collection using `add()`, `add()` takes an argument of type `E`.   |
| `addAll()`   | Add the entire contents of one collection to another by calling `addAll()`.   |
| `remove()`   | Remove an object by using `remove()`   |
| `removeAll()`   | Remove a group of objects `removeAll()`   |
| `retainAll()`   | Remove all elements except those of a specified group by calling `retainAll()`   |
| `clear()`   | To empty a collection   |
| `contains()`| Determine whether a collection contains a specific object by calling `contains()`   |
| `containsAll()`   | Determine whether one collection contains all the members of another  |
| `isEmpty()`   | Determine when a collection is empty   |
| `size()`   | The number of elements currently held in a collection can be determined by calling `size()`.   |
| `toArray()`   | Method return an array that contains the elements stored in the invoking collection.   |
| `equals()`   | Two collections can be compared for equality by calling `equals()`  |
| `Iterator()`   | Returns an iterator to a collection, these are frequently used when working with collections.   |


1) [The List Interface](./ListInterface/README.md)
- The `List` interface extends `Collection` and declares the behavior of a collection that stores a sequence of elements.
- Elements can be inserted or accessed by their position in the list, using a zero-based index.
- A list may contain duplicate elements. List is a generic interface that has this declaration.
    - `interface List<E>`

2) [The Set Interface](./ListInterface/README.md) 
- The `Set` interface defines a set. It extends `Collection` and declares the behavior of a collection that does not allow duplicate elements. Therefore `add()` method returns `false` if an attempt is made to add duplicate elements to a set.
- It does not define any additional methods of its own.
- `Set` is a generic interface that has this declaration:
    - `interface Set<E>`
    - Here, `E` specifies the type of objects that the set will hold

3) [The SortedSet Interface](./SetInterface/SortedSetInterface/README.md)
- The `SortedSet` interface extends `Set` and declares the behavior of a set sorted in `ascending` order. `SortedSet` is a generic interface that has this declaration
    - `interface SortedSet<E>`
    - Here, `E` specifies the type of objects that the set will hold

4) [The NavigableSet Interface](./SetInterface/NavigableSetInterface/README.md)

- The `NavigableSet` interface extends `SortedSet` declares the behavior or a collection that supports the retrieval of elements based on the closest-match to a given value or values.
- `NavigableSet` is a generic interface that has this declaration
    - `interface NavigableSet<E>`
    - Here, `E` specifies the type of objects that the set will hold. In addition to the methods that it `inherits` from `SortedSet`, `NavigableSet` has some additional methods.

5) [The Queue Interface](./QueueInterface/README.md)
- The `Queue` interface extends `Collection` and declares the behavior of a queue, which is often `first-in, first-out` list. However, there are types of queues in which the ordering is based upon other criteria.
- `Queue` is a generic interface that has this declaration:
    - `interface Queue<E>`
    - `E` specifies the type of objects that the queue will hold.

6) [The Deque Interface](./QueueInterface/DequeInterface/README.md)
- The `Deque` interface extends `Queue` and declares the behavior of a double-ended queue. 
- Double-ended queues can function as standard, `first-in, first-out` queues or as `last-in, first-out` stacks. ``
- `Deque` is a generic interface that has this declaration:
    - `interface Deque<E>`
    - Here, `E` specifies the type of objects that the deque will hold. In addition to the methods that it inherits from `Queue`, `Deque` adds several methods.
