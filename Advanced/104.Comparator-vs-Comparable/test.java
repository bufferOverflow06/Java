import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test{
    public static void main(String []args){
        List<Integer> nums = new ArrayList<>();

        Comparator<Integer> com = new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                if(i%10 > j%10){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };

        nums.add(66);
        nums.add(43);
        nums.add(33);
        nums.add(98);
        nums.add(36);

        Collections.sort(nums, com);
        System.out.println(nums);
    }
}
