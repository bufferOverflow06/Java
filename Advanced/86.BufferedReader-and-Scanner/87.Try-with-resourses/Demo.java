import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int num = 0;
        // BufferedReader br = null;
        // try{
        //     // InputStreamReader in = new InputStreamReader(System.in);
        //     // br = new BufferedReader(in);
        //
        //     // or
        //
        //     br = new BufferedReader(new InputStreamReader(System.in));
        //     num = Integer.parseInt(br.readLine());
        //     System.out.println(num);
        // }
        // finally{
        //     br.close();
        // }
        //
        // or
        // try with resources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }
    }
}
