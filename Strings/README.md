# Strings

## The `String` types
- created using `literals` or by using `new operator`
- When we create a String using the literals, the String will be inside a space called `String pool` -> `String str = "hello";`
    - String pool is a special area of heap memory that stores a pool of unique string literals in Java.
    - When you create a string literal in your Java code, the JVM checks if the string already exists in the string pool.
    - If it does, then the existing string is returned from the pool instead of creating a new string object. This is called string interning.

- When we create a String using the new operator, the String will be stored inside the `heap memory` -> `String str = new String("hello");`
    - If we create a String object using the new operator, a new object will be created in memory every time, even if the string value is the same.
    - if the string is created using literals the same memory location is used in the String pool.

> [!NOTE]
> Direct access to the String pool is not possible, and there is no mechanism to remove String objects from the pool, except by restarting the application.

- Which String declaration should I use?
    - always recommended to use literal style of declaration instead of new operator.
    - The main reason for `string pool` java is to `save memory`, since strings are immutable, meaning their values cannot be changed once they are created, it makes sense to reuse the same string object whenever possible instead of creating new ones.
    - By doing this, the `JVM` can avoid creating unnecessary string objects and thus reduce memory usage.

    - Another advantage of the string pool is that it can improve performance. Since string `interning` allows the JVM to reuse existing string objects, it can reduce the time and resources needed to create new strings. This can result in faster code execution and improved overall performance. In summary, string pools in Java are used to save memory and improve performance by reusing existing string objects whenever possible.

---
- The `intern` method in String
    - If necessary, it is possible to move the string value created with the new operator to the string pool using the `intern() metho`
```java
String hell = "hello";
String obj = new String("hello").intern();
System.out.println(hello == obj); // true


String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1 == s2); // false
String s3 = s2.intern();
System.out.println(s1 == s3); // true
```
- Since `intern` is a non static method we can only invoke this with the `object` of `string`.
---
- `concat` method
```java

String hello = "Hello";
hello = hello.concat.(" ").concat("World");
System.out.println(hello);

// hello.concat.(" ") -> gives string object, that is why we are able to invoke concat() again on this one
// We can have empty string value pointing to string object
String emptyString = "";
// For the above expression, there will be a representation in the heap memory,
// there will be a memory location and JVM will hold the empty String value, and
// the memory location will be pointed to `emptyString` variable
String nullString = null;
// any value is not assigned, JVM will never create any memory location for this object.
// orphan object reference variable name, which is there for the future usage inside java program
```
---

- `length()`

---

- `compareTo()`

---

- `compareToIgnoreCase()`
    - returns integer +ve, -ve or equal to zero
    - +ve means compared string is less than the one which is being compared to
    - -ve means compared string is geater than the one one which is being compared to
    - 0 means both are equal

---

- `charAt()`
    - returns char
    - if index is not present gives `StringIndexOutOfBoundsException`

---

- `isEmpty()`
    - returns boolean
    - or `lenght() == 0`
    - or `emptyString.equals("");`
        - go with last `equals` as it will handle the null strings gracefully, for other methods we get `NullPointerException`

---

- `isBlank()`
    - returns boolean
    - true if String is empty or contains only `whitespaces` else returns false

---

- `toUpperCase()`
- `toLowerCase()`
    - returns a new String
    - does not matter if String have alphanumeric or special symbols
    - if output is stored in original string, then the initial value of the string will be removed by garbase collector
    - one more version `toUpperCase(Locale.GERMAN) or toLowerCase(Locale.GERMAN)`, just so that JVM can correctly convert in respective standard

---

## `Searching for a Value`

### `String.valueOf()`
- accepts int or double or char ...
- returns String object
- can use `+` to convert to String

### `indexOf()`
- returns the index of first occurrence of a specified substring within a string. If the substring is not found returns -1.

### `contains()`
- checks whether substring is present in the given string
- returns a boolean value

### `startsWith()` & `endsWith()`
- used to check if a string starts or ends with a specified prefix or suffix

### `matches()`
- used for more complex pattern matching using regular expressions
- returns boolean
```java
String originalString = "Hello, World";

boolean originalString = originalString.matches(".*world.*");
```
- The methods mentioned above are case sensitive. If we need a case insensitive search, you can convert both the original string and the search pattern to lowercase(or uppercase) using `toLowerCase()` or `toUpperCase()`

---

## `Trimming of a String`
- gets rid o any extra spaces or control characters at the beginning and end of a string.
```java
String java1 = " java ".trim();// java
String java2 = "java ".trim();// java
String java3 = "\n \t java \n\t".trim(); // java
String java4 = " ja va ".trim();// ja va
String java5 = " ja\n\tva ".trim(); // ja\n\tva
```
- have the capable of trimining escape characters also
- removes characters with unicode value less `\u0020(decimal 32)`
- removes only white spaces or escape sequence at the beginning or end not in the middle of a string

---

## Fetching `Substring` from a String
```java
String originalString = "Hello World!";
String substring1 = originalString.substring(startIndex);
String substring1 = originalString.substring(startIndex, endIndex);
```
- startIndex -> inclusive
- endIndex -> Exclusive
- Negative indices or an endIndex less than the startIndex will result in exception(StringIndexOutOfBoundsException)
- won't modify the original string. Instead, it creates and returns a new string.
- length of resulting substring is equal to `endIndex - startIndex`, if only one parameter then length of string - startIndex

---

## `Replacing` a part of a String

### `replace()`
- replace a character or sequence of character
```java
// 1
String originalString = "Hello, World";
String replacedString = originalString.replace('o', '*'); // Hell*, W*rld
String replacedString = originalString.replace("World", "Universe"); // Hello, Universe

// 2
String originalString "abababab";
String replacedString = originalString.replace('ab', 'x'); // xxxx
```


### `replaceAll()`
- `replaceAll(String regex, String replacement)`
- method uses regular expression in regex to find matches.
- returns new String object by replacing each match with replacement
```java
String originalString = "Java is fun!";
String replacedString = originalString.replaceAll("a|e|i|o|u", "*"); // J*v* *s f*n
```

### `replaceFirst()`
- same as replaceAll(), except that it replaces only the first match with given replacement

---

## Splitting Strings
- Split strings into an array of substring based on a specified delimiter.
```java
String parts[] = originalString.split(delimiter);

// 1
String fruits = "apple,orange,banana,grape";
String parts[] = fruits.split(","); // ["apple", "orange", "banana", "grape"]
```

---

## Joining Strings
- introduced in java
- designed to concatenate a list of strings with a specified delimiter
```java
// Syntax
String result = String.join(delimiter, elements)

String array[] = String.join(" ", "Hello", "World"); // Hello World

// empty string
String result = String.join("", "Java is", "fun and", "powerful");

// empty List
List<String> emptyList = Collections.emptyList();
String result = String.join(", ", emptyList);
```
- if we want to concatenate strings without any delimiter you can use an empty string ("") as the delimiter.
- Even if `list` is empty, `String.join` gracefully handles it and output will be an empty string.
- if the element in list is `null` it will be treated as the string `"null"` in the resulting string.
- `String.join` internally uses `StringBuilder` for concatenation, making it efficient for joining multiple strings

---

## Formatting String messages
- acts as a placeholder
```java
String message = "Hello! %s, you have %d messages";
String var1 = String.format(message, "AAA", 3);
String var2 = String.format(message, "BBB", 5);
```
- for `String` -> `%s`
- for `Integer` -> `%d` (digit)
- for `character` -> `%c`
- for `boolean` -> `%b`
- for `decimal` -> `%f` (float)
    - to set precision say `two` places after the point we can use `%.2f`
- if we want some padding we can use `%5d`
    - this will add white spaces just before placeholder
```java
String message = "The number is %5d";
String number = String.format(message, 4); // The number is    4; padded with 4spaces to make it 5 characters wide

// To control which placeholder to be placed
String message = "Hi!, My name is %3$s I am %2$d years old, I live in %1$s";
String var = String.format(message, "Bangalore", 23, "AAA"); // Hi!, My name is AAA I am 23 years old, I live in Bangalore
```

---

## `printf()`
```java
System.out.printf("Name: %s, Age: %d%n", "John", 23); // Name: Jhon, Age 23
System.out.printf("Price: %0.2f%n", 19.99); // Price: 19.99
System.out.printf("Grade: %c%n", 'A'); // Grade: A
System.out.printf("Java is fun? %b%n", true); // Java is fun? true
```

- `%n` moves to the cursor to the next line
- dynamic placeholder also works similarly here
```java
// example
String item = "bananas";
int quantity = 7;
double pricePerUnit = 1.99;
System.out.printf("Don't forget to buy %2$d %3$s at $%1$.2f each!", pricePerUnit, quantity, item);
```

---

## Strings mutable

- String class is immutable
- there are two mutable companion classes for the String class:
    - `StringBuilder` and `StringBuffer`. These classes should be employed when there is a need to modify the contents of a string.

- The immutability applies to the String object stored in memory, not the reference variable of the String type. If you intend to have a reference variable consistently point to the same String object in memory, you need to declare the reference variable as `final`
```java
final String s1 = "Hi";
s1 = "Hello! World"; // Compilation error

```
### Ways to create mutable strings in Java

1. `String Builder`:
- This class is designed for building and manipulating strings.
- It provides various methods for appending, inserting, replacing, and deleting characters in a string
- They are not `thread-safe`
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb.toString()); // Hello World
```

2. `StringBuffer`
- Similar to `StringBuilder` and provides same functionality for manipulating strings.
- only difference is that StringBuffer is `thread-safe`.
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb.toString()); // Hello World
```

- Use `StringBuilder` when:
    - working with a single-threaded environment.
    - where higher performance is needed and thread safety is not a concern
- Use `StringBuffer` when:
    - working in a `multi threaded environment` where thread safety is critical

- Both supports various mutable operations using methods like `append`, `insert`, `delete`, `replace`...
- Both classes have `reverse()` method, which replaces its contents with the same sequences of characters, but in reverse order.

```java
// Similar methods are present in StringBuffer also
StringBuilder sb = new StringBuilder();
sb.append("World"); // World
sb.inseert(0, "Hello "); // Hello World
sb.deleteCharAt(4);// Hell World
sb.insert(4, o);// Hello World
sb.setLength(5);// Hello
sb.reverse();// olleH
```

3. `CharArrayWriter`:
- This class allows you to write characters to a buffer and then convert them to a string.
```java
CharArrayWriter cw = new CharArrayWriter();
cw.write("hello");
cw.write(" world");
String s = cw.toString();
System.out.println(s);
```
---

## Text Block in Java
- introduced in Java 15
- using `triple double quotes(""")`
```java
String textBlock = """
        <html>
            <head></head>
            <body>
                <p> Hello! World</p>
            </body>
        </html>
""";
System.out.println(textBlock);
```
- can also use text blocks to create formatted strings, using placeholders like `%s` or `%d`
```java

String name = "Alice";
String age = 23;

String message = """
    Hello, My name is %s
    and I am %d years old.

""";

String formattedMessage = String.format(message, name, age);
System.out.println(formattedMessage);
```
---

### String to Primitive data type values
- Parsing involves converting a string representation of a value into its corresponding primitive data type. In Java, done using methods provided by wrapper classes.
```java
// int
String strNumber = "123";
int parsedNumber = Integer.parseInt(strNumber); // 123

// double
String strDouble = "3.14";
double parsedDobule = Double.parseDouble(strDouble);

// double
String strFloat = "3.14";
double parsedFloat = Float.parseFloat(strFloat);

// long
String strLong = "32534543454";
long parsedLong = Long.parseLong(strLong) //32534543454

// boolean
// if try to pass any other value other than `ture/false`, the result will be false
String strBoolean = "true";
boolean parsedBoolean = Boolean.parseBoolean(strBoolean); // true
```
- During parsing if a valid number is not provided, the `NumberFormatException` will be thrown at runtime. So it is recommended to handle exception inside the code.


- In addition to parsing into primitive data  types direly, we can also use the constructor of the wrapper classes
> [!NOTE]
> This approach is not recommended and **deprecated** from `Java 9`
```java
String strNumber = "455";
Integer intergerObject = new Integer(strNumber); // 455
```

- Converting String to char involves extracting a single character from the string
- We can either
```java
// 1
String str = "Hello";
char firstChar = str.charAt(0);

/ 2
char charArray[] = str.toCharArray();
char secondChar = charArray[1];
```
---
