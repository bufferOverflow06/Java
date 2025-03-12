public class Demo{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        int[] nums = new int[5];
        String str = null;
        try{
            j = 18/i;
            System.out.println(str.length());
            System.out.println(nums[1]);
            System.out.println(nums[5]);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by zero  => " + e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("stay inside bounds => " + e);
        }
        catch(Exception e){
            System.out.println("Something went wrong =>" + e);
        }
        System.out.println("Hello World");
    }
}

