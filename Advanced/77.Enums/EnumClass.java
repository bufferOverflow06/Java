// Cannot extend enum class with any other class

enum Laptops{
    Macbook(2000), XPS(2200), Surface, ThinkPad(1800);
    private int price;

    // if value not passed we have to include a default constructor
    private Laptops(){
        price = 500;
    }

    // We are using a private constructor not a default or public because we are creating the object in the same class itself
    private Laptops(int price){
        this.price = price;
        System.out.println("in Laptop " + this.name()); // .name gives the enums
    }

    public int getPrice(){
        return price;

    }

    public void setPrice(){
        this.price = price;
    }
}

public class EnumClass {
    public static void main(String []args){
        // Laptops lap = Laptops.ThinkPad;
        // System.out.println(lap + " : " + lap.getPrice());

        for(Laptops lap : Laptops.values()){ // .values() gives the array
            System.out.println(lap + " : " + lap.getPrice());
        }
    }
}

// output
// in Laptop Macbook
// in Laptop XPS
// in Laptop ThinkPad
// Macbook : 2000
// XPS : 2200
// Surface : 500
// ThinkPad : 1800
