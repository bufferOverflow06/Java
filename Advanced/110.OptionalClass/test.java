import java.util.*;

public class test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("AAA", "BBB", "CCC", "DDD", "EEE");

        // String name = names.stream()
        //                     .filter(str -> str.contains("C"))
        //                     .findFirst();
        // This cannot be done as findFirst() method return Optional<String> because there might be null which gives NullPointerException.
        // instead we can get
        Optional<String> name = names.stream()
        .filter(str -> str.contains("C"))
        .findFirst();

        // System.out.println(name);

        // we can also do this instead
        String name1 = names.stream()
        .filter(str -> str.contains("X"))
        .findFirst()
        .orElse("Not found");

        System.out.println(name1);
    }
}
