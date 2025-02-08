// this() will execute the constructor of the same class

class A extends Object{ // Every class in java extends Object class
    public A(){
        super();
        System.out.println("in A");
    }
    public A(int n){
        super();
        System.out.println("in A int");
    }

}

class B extends A{
    public B(){
        super();
        System.out.println("in B");
    }
    public B(int n){
        this();
        System.out.println("in B int");
    }
}

public class test{
    public static void main(String[] args) {
        B obj = new B(5);
    }
}
