interface A{
    int a = 4; // final and static by default
    String city = "Bengaluru";
    void show(); // public and abstract by default
    void config();
}

// multiple interfaces
interface X{
    void run();
}

interface Y extends X{
    // The run must be defined in the class which implements this inteface

}

class B implements A, Y{
    public void show(){
        System.out.println("In show");
    }
    public void config(){
        System.out.println("In config");
    }
    public void run(){
        System.out.println("In run");
    }
}

public class test {

    public static void main(String[] args) {
        A obj = new B();
        obj.show();
        obj.config();
        // A.city = "random city"; // cannot do this
        System.out.println(A.city);

        // For A class to access run
        X obj1 = new B();
        obj1.run();
    }
}

