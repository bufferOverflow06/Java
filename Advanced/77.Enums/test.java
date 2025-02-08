// enums - named constant
enum Status{
    Running, Failed, Pending, Success;
}

public class test {

    public static void main(String[] args) {
        // Status s = Status.Success;
        // System.out.println(s);
        // System.out.println(s.ordinal());


        // Status arr[] = Status.values();

        // System.out.println(arr[2]);
        // for(Status item : arr){
        //     System.out.println(item + " " + item.ordinal());
        // }

        // Status s = Status.Pending;
        // if(s == Status.Running){
        //     System.out.println("All good");
        // }
        // else if(s == Status.Failed){
        //     System.out.println("Try again");
        // }
        // else if(s == Status.Pending){
        //     System.out.println("Please Wait");
        // }
        // else{
        //     System.out.println("Done");
        // }

        // using switch
        Status s = Status.Pending;
        switch(s){
            case Running:
                System.out.println("All good");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Pending:
                System.out.println("Please Wait");
                break;
            case Success:
                System.out.println("Done");
                break;
        }
    }
}
