class A implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("hi");
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){e.printStackTrace();}
        }
    }
}

class B implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){e.printStackTrace();}
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        // Runnable obj1 = new A();
        Runnable obj2 = new B();

        // or
        // Runnable obj1 = new Runnable(){
        //     public void run(){
        //         for (int i = 0; i < 10; i++) {
        //             System.out.println("hi");
        //             try{
        //                 Thread.sleep(10);
        //             }
        //             catch(InterruptedException e){e.printStackTrace();}
        //         }
        //     }
        // };

        // or
        // as Runnable is a FunctionalInterface we can use lambda expression

        Runnable obj1 = () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hi");
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){e.printStackTrace();}
                }
            };



        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}
