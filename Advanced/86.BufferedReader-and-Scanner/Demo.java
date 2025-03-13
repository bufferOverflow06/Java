import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException{
        System.out.println("Enter a number");

        InputStreamReader in = new InputStreamReader(System.in); // requires an InputStreamReader
        BufferedReader bf = new BufferedReader(in); // requires a Reader

        int num = Integer.parseInt(bf.readLine()); // bf.read()
        System.out.println(num);

        bf.close();
    }
}
