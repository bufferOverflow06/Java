// Create a generic Triple<X, Y, Z> class.
//
public class Main {
    public static void main(String[] args) {
        Triple<String, Integer, Double> personData = new Triple<>("AAA", 22, 98.7);
        personData.print();  // Output: First: AAA, Second: 22, Third: 98.7

        Triple<Integer, Boolean, String> mixedData = new Triple<>(42, true, "Passed");
        mixedData.print();  // Output: First: 42, Second: true, Third: Passed

        Triple<String, String, Integer> book = new Triple<>("Title", "Author", 1999);
        book.print();
    }
}
