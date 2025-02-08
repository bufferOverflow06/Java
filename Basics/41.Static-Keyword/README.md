## Static-Keyword

- `Static variable`
    - static variables are shared across all the `objects`.
    - static variables should be called using their class names

- `Static methods`
    - can call `static methods` directly with the help of the class names
    - we can use a `static variable` inside a `static method` but we cannot use a `non static variable` inside a `static method`.

- `Static block`
    - to initialize a static variable.
    - `static block` is called only once irresepctive of the number of objects created.
        ```java
        <!-- static block -->
        static{

        }
        ```
    - it is executed before the constructor.
    - `Class loader` and then `Object` gets instantiated.
        - Can use `Class.forName("classname");`

