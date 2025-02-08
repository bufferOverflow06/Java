class A{
    public void method1(){
        System.out.println("in A method1");
    }
}

class B extends A{
    @Override // gives the error
    public void method1Type(){
        System.out.println("in B method1");
    }
}

public class test {
    public static void main(String[] args) {
        B obj = new B();
        obj.method1();
    }
}
