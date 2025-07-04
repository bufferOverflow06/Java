# Generics
---

### Example

```java
class Box {
    Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
```

---

## Why use `Object`?

In Java, **`Object` is the parent class of all classes**.

So:

* You can store **any type** (String, Integer, etc.) inside a variable of type `Object`.
* This is how we write **reusable code** without caring about the data type.

```java
Box b = new Box();
b.setValue("Hello");         // String
b.setValue(123);             // Integer
b.setValue(3.14);            // Double
```

### So, why use `Object`?

We use it to allow storing **any data type**, but...

---

## What's the problem?

The `getValue()` method also returns an `Object`.
So **you must cast** the result back to the type you expect:

```java
Box b = new Box();
b.setValue("AAA");

String s = (String) b.getValue();  // You manually cast it
```

If you're wrong about the type:

```java
b.setValue(123);           // Actually an Integer
String s = (String) b.getValue();  // BOOM! ClassCastException
```

> **This crash happens at runtime**, because Java doesn’t know the type inside the Box.

---

## Solution: Generics

With generics, you **tell Java the type in advance**:

```java
Box<String> b = new Box<>();
b.setValue("AAA");

String s = b.getValue();  // No casting needed, it's type-safe
```

Now Java guarantees:

* Only `String` can be stored
* Only `String` will come out

If you do `b.setValue(123);`, the compiler will give an error.

---

### Summary:

| Approach       | Type-Safety | Needs Casting | Can Store Any Type |
| -------------- | ----------- | ------------- | ------------------ |
| Using Object   | ❌ No        | ✅ Yes         | ✅ Yes              |
| Using Generics | ✅ Yes       | ❌ No          | ✅ Yes              |

---

##  Clear analogy:

Think of `Object` like a **big empty bag** — you can put anything in it, but you don’t know what’s inside unless you check.

Generics are like **labeling the bag** — “this bag only holds apples” — so Java knows and protects you from putting the wrong item in or pulling the wrong item out.
