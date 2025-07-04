
public class Main{
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello");

        String str = stringBox.getValue();
        // System.out.println(str);


        Pair<String, Integer> pair = new Pair<>("Age", 25);
        // pair.print();
        //
        Integer nums[] = {1, 2, 3, 4};
        String names[] = {"AAA", "BBB", "CCC", "DDD"};

        Util.printArray(nums);
        Util.printArray(names);
    }
}
