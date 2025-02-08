abstract class A{
    public abstract void show();
}

public class test{

    public static void main(String[] args) {
        // If we want to implement the interface or the abstract class once, then we can use anonymous inner class
        A obj = new A(){ // new implementation
            public void show(){
                System.out.println("in new Show");
            }
        };
        // we can use anonymous inner class for abstract class as well
        // we can also provide multiple implementations

        obj.show();
    }
}
