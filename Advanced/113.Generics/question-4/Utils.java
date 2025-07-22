
public class Utils{
    public static <T extends Comparable<T>> int countGreaterThan(T[] arr, T value){
        int count = 0;
        for(T elem : arr){
            if(elem.compareTo(value) > 0){
                count++;
            }
        }
        return count;
    }
}
