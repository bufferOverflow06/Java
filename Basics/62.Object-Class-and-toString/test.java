// Generate the toString(), equals() and hashCode() from the inbuilt IDE feature

class Laptop{
    String model;
    int price;

    // If I override toString() method
    public String toString(){ // getClass().getName() + "@" + Integer.toHexString(hashCode());
        // return "Hey";
        return model + ": " + price;
    }

    // If we want to compare the objects based on their values we override equals() method
    public boolean equals(Laptop that){
        if(this.model.equals(that.model) && this.price == that.price)
            return true;
        return false;
    }
}

public class test{
    public static void main(String[] args) {
        Laptop obj = new Laptop();
        obj.model = "Asus Tuf f17";
        obj.price = 80000;

        System.out.println(obj); // same as System.out.println(obj.toString());
        // toString() is the method of the Object class by default

        Laptop obj1 = new Laptop();
        obj1.model = "Asus Tuf f17"; // false for different model
        obj1.price = 80000;

        boolean res = obj.equals(obj1); // same compares the hex values from the hashCode()
        System.out.println(res);
    }
}
