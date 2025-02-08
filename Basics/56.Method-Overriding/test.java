// Method overriding
// Method have same name, same parameters as well but have some changes for ex. return type
class A{
    public void show(){
        System.out.println("in A show");
    }
    public void config(){
        System.out.println("in A config");
    }
}

class B extends A{
    // method overriding
    public void show(){ // showing off own class's feature
        System.out.println("in B show");
    }
}

// example 1
class Calc{
    public int add(int n1, int n2){
        return n1+n2;
    }
}

class AdvCalc extends Calc{
    // public int add(int n1, int n2){
    //     return n1+n2+1;
    // }
}

public class test{
    public static void main(String[] args) {
        // B obj = new B();
        // obj.show();

        AdvCalc obj1 = new AdvCalc();
        int res = obj1.add(5, 3);
        System.out.println(res);
    }
}
