class A{
    public void show1(){
        System.out.println("in A show");
    }
}

class B extends A{
    public void show2(){
        System.out.println("in B show");
    }
}

public class Demo {
    public static void main(String[] args) {
        A obj = new B(); // same as A obj = (A) new B(); upcasting implicitly works
        obj.show1();

        B obj1 = (B)obj; // downcasting to B to access show2();
        obj1.show2();
    }
}
