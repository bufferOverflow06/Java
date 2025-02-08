class Mobile{
    String brand; // instance variables
    int price;
    // String name;
    static String name; // shared across all the variables
    // static class member

    public void show(){ // instance methods
        System.out.println(brand + " : " + price + " : " + name);
    }

    public static void show1(){
        System.out.println("inside static method");
        // System.out.println(brand + " : " + price + " : " + name); // here we can only access name (non static variables).
    // We don't know which object we are referring to and hence there will be confusion.
    }

    public static void show1(Mobile obj){
        System.out.println(obj.brand + " : " + obj.price + " : " + obj.name);
    }
}

public class test {

    public static void main(String[] args) {
        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;
        Mobile.name = "SmartPhone"; // Static variables should be called with their classnames.
        // We can use ojbects names

        Mobile obj2 = new Mobile();
        obj2.brand = "Samsung";
        obj2.price = 1000;
        obj2.name = "Phone"; // This should be Mobile.name = "Phone";

        obj1.show();
        obj2.show();

        // Mobile.show1(); // Calling direclty using the class name.

        // We can do this
        Mobile.show1(obj1);
    }
}
