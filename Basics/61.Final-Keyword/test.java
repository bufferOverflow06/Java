// final - variable, method, class
// if variable is final the variable becomes constant
// if a method is final then we can stop method overriding
// if a class is final then that class cannot inherited by a subclass, we are stopping the inheritance.

final class Calc{
    public final void show(){ // method overriding not possible for show
        System.out.println("in class Calc");
    }
    public void add(int a, int b){
        System.out.println(a + b);
    }
}

// class AdvCalc extends Calc{ // Cannot do this
//
// }

public class test{
    public static void main(String args[]){
        final int num = 8;
        // num = 9; // Error cannot change the value
        System.out.println(num);
    }
}
