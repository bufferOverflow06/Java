class Mobile{
    String brand; // instance variables
    int price;
    static String name; // shared across all the variables
    // static class member

    static{
        name = "Phone";
        System.out.println("in static block");
    }

    public Mobile(){
        brand = "";
        price = 200;
    }
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

public class testStaticBlock {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("Mobile");
    }
}
