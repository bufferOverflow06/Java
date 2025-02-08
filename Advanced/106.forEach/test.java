import java.util.*;
import java.util.function.Consumer;

public class test{
    public static void main(String args[]){
        List<Integer> nums = Arrays.asList(4, 5, 6, 2, 9);

        // nums.forEach(n -> System.out.println(n));

        // Behind the scenes
        // Consumer<Integer> con = new Consumer<Integer>() {
        //     public void accept(Integer n){
        //         System.out.println(n);
        //     }
        // };

        // using lambda expression
        Consumer<Integer> con = (n) -> System.out.println(n);
        nums.forEach(con); /* this is nothing but nums.forEach(n -> System.out.println(n)); */
    }
}
