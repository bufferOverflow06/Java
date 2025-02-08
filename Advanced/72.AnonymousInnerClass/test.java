class A{
    public void show(){
        System.out.println("in A show");
    }
}

// class B extends A{
//     public void show(){
//         System.out.println("in B show");
//     }
// }

// Suppose the above class is used only once then

public class test{

    public static void main(String[] args) {
        A obj = new A(){ // new implementation
            public void show(){
                System.out.println("in new Show");
            }
        };

        obj.show();
    }
}
// output : in new show
