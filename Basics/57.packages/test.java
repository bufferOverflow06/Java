import tools.Calc;
import tools.AdvCalc;

//instead
// import tools.*; // all the files inside tools and not folders

public class test{
    public static void main(String[] args) {
        Calc obj1 = new Calc();
        AdvCalc obj2 = new AdvCalc();
        int res = obj2.add(5, 3);
        System.out.println(res);
    }
}
