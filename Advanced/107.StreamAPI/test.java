// Stream can be used only once

import java.util.*;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 2, 6, 7, 9);

        Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n%2 == 0); // 4, 2, 6
        // Stream<Integer> s3 = s2.map(n -> n*2); // 8, 4, 12
        //
        // int result = s3.reduce(0, (c, e) -> c+e); // 24

        // all in one
        int result = nums.stream()
                        .filter(n -> n%2==0)
                        .map(n -> n*2)
                        .reduce(0, (c, e) -> c+e);

        System.out.print(result);

        // s3.forEach(n -> System.out.println(n));
    }
}
