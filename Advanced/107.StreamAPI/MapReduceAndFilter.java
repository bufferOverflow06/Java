import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapReduceAndFilter {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 4, 5, 6);

        // Predicate<Integer> p = new Predicate<Integer>() {
        //    public boolean test(Integer n){
        //         return n%2 == 0;
        //     }
        // };

        // or
        Predicate<Integer> p = n -> n%2 == 0;

        // For map
        // Function<Integer, Integer> fun = new Function<Integer, Integer>() {
        //     public Integer apply(Integer n){
        //         return n*2;
        //     }
        // };
        // Using lambda expression
        Function<Integer, Integer> fun = (n) -> n*2;


        int result = nums.stream()
                        .filter(p) // same as .filter(n -> n%2 == 0)
                        .map(fun) // same as .map(n -> n*2)
                        .reduce(0, (c, e) -> c+e);

        // We can also sort stream
        Stream<Integer>  sortedValues = nums.stream()
        .filter(p)
        .sorted();

        sortedValues.forEach(n -> System.out.println(n));
    }
}
