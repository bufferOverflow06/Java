class A{
    public void show() throws ClassNotFoundException{
        Class.forName("Demo");
    }
}

public class throwsKeyword {
    static{
        System.out.println("Class Loaded");
    }

    public static void main(String[] args) {
        A obj = new A();
        try{
            obj.show();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
