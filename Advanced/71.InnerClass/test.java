class A{
    int age;
    public void show(){
        System.out.println("in show");
    }

    class B{ // 2. We can make the inner class static but not the outerclass
        public void config(){
            System.out.println("in config");
        }
    }
}

public class test {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        // we can't create B's object directly
        // B obj1 = new B();
        // instead
        A.B obj1 = obj.new B(); // We need object of outer class to create the object of inner class.
        obj1.config();
    }
}

