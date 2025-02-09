import java.util.*;

public class test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("abc", "def", "ghi");

        // List<String> uNames = names.stream()
        //                     .map(name -> name.toUpperCase())
        //                     .toList();

        // we can do
        List<String> uNames = names.stream()
        .map(String::toUpperCase) // Method reference
        .toList();

        System.out.println(uNames);

        // using forEach to print the above names
        uNames.forEach(System.out::println); // println belongs to System.out

        // We can pass a method name inside a method by specifying that this method will do the work for you, we have to mention the class name or the object name to use it
    }
}

// output
// [ABC, DEF, GHI]
// ABC
// DEF
// GHI

