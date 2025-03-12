# Exception Handling

# Error
1. Compile time error
    - syntactical error
2. Runtime error
    - Exceptions are basically runtime errors
3. Logical error

- `try` block -> put critical statements that throws exception
- `catch` block will be executed only in the case of exception otherwise catch block will be skipped.
- even in try if there are multiple exceptions then each and every exception must be handled separately

## try with multiple catch block

```java

// example

public class Demo{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        int[] nums = new int[5];
        String str = null;
        try{
            j = 18/i;
            System.out.println(str.length());
            System.out.println(nums[1]);
            System.out.println(nums[5]);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("stay inside bounds");
        }

        System.out.println("Hello World");
    }
}

// output
// Cannot divide by zero
// Stay inside bounds
// Hello world
```

```java

// example

public class Demo{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        int[] nums = new int[5];
        String str = null;
        try{
            j = 18/2;
            System.out.println(str.length()); /* the execution will be stopped in this try block after this line */
            System.out.println(nums[1]);
            System.out.println(nums[5]);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("stay inside bounds");
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }


        System.out.println("Hello World");
    }
}

// output
//
// Something went wrong
// Hello world
```

## Exception Hierarchy

```
            Object
                |
            Throwable -> class
                |
         -----------------
        |                 |
        Error           Exception
                          |
                    -----------------------------
                    |                           |
                Unchecked Exception         Checked Exception
                    |                               |
                    |                       ---------------------------------
                    |                       |               |               |
                RuntimeException        SQLException    IOException         ...
                    |
                    |---> ArithmeticException
                    |
                    |---> ArrayIndexOutOfBoundsException
                    |
                    |---> NullPointerException
```
- Error can't be handled it stops the execution immediately
    - examples
        - ThreadDeath
        - IOError
        - Virtual Machine error
            - Out of memory
- Exception must be handled
- Checked exception must be handled compulsorily

# `throw` keyword

```java
// throw keyword example

- `throw` keyword is used to throw an Exception and then the catch block will catch it

public class Demo{
    public static void main(String[] args){
        int i = 20;
        int j = 0;
        try{
            j = 18/i;
            if(j == 0){

                throw new ArithmeticException();
                // we can also pass the message in the construtor as in
                // ArithmeticException("I don't want to print zero")
            }
        }
        catch(ArithmeticException e){
            j = 18/1;
            System.out.println("thats the default output " + e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("stay inside bounds");
        }

        System.out.println("Hello World");
    }
}
```
