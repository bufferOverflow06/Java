## Local variable type inference

- means that you can declare variables `without having to specify the associated type`
```java
// Before
List<String> list = new ArrayList<String>();
int myFavoriteNumber = 12;

// After
var list = new ArrayList<String>();
var myFavoriteNumber = 12;
```

```java
// Before
String programmingLanguage = "Java";

// After
var programmingLanguage = "Java";
programmingLanguage = "Kotlin";
```

- Still statically typed once type is assigned cannot it be changed.

### var is Not a Keyword
- `var` is not a general keyword, it is a `reserved type name` or a `context-senstive` keyword.

- Code that uses `var` as **variable**, **method**, or **package name will not be affected**
- Code that uses `var` as **class or interface name will be affected**
- Using `var` as a name for anything is rare in practice anyway.

### Local variable type inference will be restricated to:

```java
// Initializers
var myName = "Sujan";

// Indexes in enhanced for-loops
for(var s : myArray){...}

// Local variables initialized in a traditional for-loop
for(var i = 0; i < 10; i++){...}
```

### What doesn't work

- You must initialize variable; you cannot just declare them
`var x`;

-  Similarly in other scopes
`for(var i; i < 10; i++){var str;}`

- Not available for method parameters, constructor parameters, method return types, fields, catch formats, or any other variable declaration.
