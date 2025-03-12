class customException extends Exception{
    public customException(String string){
        super(string);
    }
}

public class CustomException {
    public static void main(String[] args) {
        int i = 20;
        int j = 0;
        try{
            j = 18/i;
            if(j == 0){

                throw new customException("some random text");
                // we can also pass the message in the construtor as in
                // ArithmeticException("I don't want to print zero")
            }
        }
        catch(customException e){
            j = 18/1;
            System.out.println("thats the default output " + e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("stay inside bounds");
        }

        System.out.println("Hello World");
    }
}
