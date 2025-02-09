import java.util.*;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {

        int size = 10_000;
        List<Integer> arr = new ArrayList<>(size);
        Random ran = new Random();

        for(int i = 0; i < size; i++){
            arr.add(ran.nextInt(100));
        }

        int sum1 = arr.stream()
                        .map(n -> n*2)
                        .reduce(0, (c, e) -> c+e);
        // System.out.println(sum1);

        // same thing
        long startSeq = System.currentTimeMillis();
        int sum2 = arr.stream()
        .map(i -> {
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
            }

            return i*2;
        })
        .mapToInt(i -> i) // convert to int
        .sum();
        long endSeq = System.currentTimeMillis();

        // Using parallel stream
        long startPara = System.currentTimeMillis();
        int sum3 = arr.parallelStream()
        .map(i -> {
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
            }

            return i*2;
        })
        .mapToInt(i -> i) // convert to int
        .sum();
        long endPara = System.currentTimeMillis();

        System.out.println(sum1 + " " + sum2 + " " + sum3);
        System.out.println("Seq: " + (endSeq - startSeq));
        System.out.println("Para: " + (endPara - startPara));
    }
}
