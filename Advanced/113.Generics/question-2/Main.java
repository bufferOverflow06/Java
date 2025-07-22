public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("Before swap:");
        for (String name : names) System.out.print(name + " ");
        System.out.println();

        Utils.swap(names, 0, 2);  // Swapping "Alice" and "Charlie"

        System.out.println("After swap:");
        for (String name : names) System.out.print(name + " ");
        System.out.println();

        System.out.println("Before number swap:");
        for (int n : numbers) System.out.print(n + " ");
        System.out.println();

        Utils.swap(numbers, 1, 2);  // Swapping 20 and 30

        System.out.println("After number swap:");
        for (int n : numbers) System.out.print(n + " ");
    }
}
