class A{
    public void show(){
        System.out.println("in class A");
    }
}

class B extends A{
    public void show(){
        System.out.println("in class B");
    }
}

class C extends A{
    public void show(){
        System.out.println("in class C");
    }
}

public class test{
    public static void main(String[] args) {
        A obj = new A(); // Type of obj is A but implementation is B
        // We can mention the type of parent but the object can be of child
        obj.show();

        obj = new B();
        obj.show();

        obj = new C();
        obj.show();
    }
}

