// Q1: Create a generic class Container<T> with methods add, get.
//
public class Main{
    public static void main(String args[]){
        // String container
        Container<String> stringContainer = new Container<>();
        stringContainer.add("Hello, AAA");
        System.out.println(stringContainer.get());

        // Integer Container
        Container<Integer> integerContainer = new Container<>();
        integerContainer.add(100);
        System.out.println(integerContainer.get());

        // Double Container
        Container<Double> doubleContainer = new Container<>();
        doubleContainer.add(99.99);
        System.out.println(doubleContainer.get());
    }
}
