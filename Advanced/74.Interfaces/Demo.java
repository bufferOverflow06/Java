interface Computer{
    void code();
}

class Laptop implements Computer{
    public void code(){
        System.out.println("code, compile, run");
    }
}

class Desktop implements Computer{
    public void code(){
        System.out.println("code, compile run: Faster");
    }
}

class Developer{
    public void devApp(Computer comp){
        comp.code();
    }
}

public class Demo {
    public static void main(String[] args) {
        Computer lap = new Laptop(); // Inteface as reference
        Computer desk = new Desktop();

        Developer random = new Developer();
        random.devApp(desk);
    }
}
