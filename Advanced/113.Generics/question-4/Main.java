// Question 4: countGreaterThan() using generics with Comparable<T>

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {5, 10, 20, 25, 2};
        int count = Utils.countGreaterThan(nums, 10);
        System.out.println("Count greater than 10: " + count);  // Output: 2

        String[] words = {"apple", "banana", "mango", "grape"};
        int wordCount = Utils.countGreaterThan(words, "banana");
        System.out.println("Words greater than 'banana': " + wordCount); // Output: 2 ("mango", "grape")
    }
}
