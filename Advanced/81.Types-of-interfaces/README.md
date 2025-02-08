## Types of Intefaces

1. Normal interface
    - Two or more methods
```java
interface interface_name{

}
```
2. Functional Interface (Single Abstract Method (SAM))
    - If the interface has only `one method`
```java
interface interface_name{
    // single method declration
}
```

3. Marker Interface
    - Which has no methods/ blank interface
    - Update something to the compiler
        - ex. serialization and deserialization of objects, we can create a class and give permission with the help of `markder interface`.
```java
interface interface_name{

}
```

