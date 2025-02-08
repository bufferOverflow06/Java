@FunctionalInterface
interface A{
    // void show();
    // if there is a parameter
    void show(int i);
}

public class test{
    public static void main(String[] args) {
        A obj = (i) -> { // if one statement we can skip this bracket as well
            // if one variablen then no need of the brackets as well
            System.out.println("in new show");
        };
        obj.show(5);

    }
}
