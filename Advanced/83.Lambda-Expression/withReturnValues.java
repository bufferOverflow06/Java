// lambda expression only works with the functional interface
interface A{
    int add(int i, int j);
}

public class withReturnValues{
    public static void main(String[] args) {
        // A obj = new A(){
        //     public int add(int i, int j){
        //         return i + j;
        //     }
        // };

        // using lambda expression
        // A obj = (int i, int j) -> {
        //     return i + j;
        // };

        // or
        A obj = (i, j) -> i + j;

        int result = obj.add(5, 4);
        System.out.println(result);
    }
}
