public class Demo{
    public static void main(String[] args) {
        int num = 7;
        // how to store it in class type or the object type
        // Integer num1 = new Integer(num) deprecated -> boxing
            // - taking a primitive value and storing it in an object
            // -
        Integer num1 = num; // here num is converted to Integer object num1 this is `Autoboxing`
        // here Integer is the wrapper class
        System.out.println(num1);

        int num2 = num1.intValue(); // Unboxing getting the value from the object type to the primitive type
        // if we do
        // int num2 = num1; // auto-unboxing;
        System.out.println(num2);

        String str = "12";
        // Suppose we want to double this number, we can do
        int num3 = Integer.parseInt(str);
        System.out.println(num3 * 2);
    }
}
