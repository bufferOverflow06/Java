@FunctionalInterface
interface A{
    void show();
}

// class B implements A{
//     public void show(){
//         System.out.println("in B show");
//     }
// }

public class functionalInterface{
    public static void main(String[] args) {
        A obj = new A(){
            public void show(){
                System.out.println("in new show");
            }
        };
        obj.show();

    }
}
// We can use lambda expressions only with functionalInterface next section
