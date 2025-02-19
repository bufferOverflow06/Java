package mappingRelationships;

import jakarta.persistence.*;

import java.util.List;

@Entity
// - Adding columns from a class without creating a new class
public class Laptop {
    // no primary key
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;

    @ManyToMany(mappedBy = "laptops")
    // (this will map any one column so that there won't be extra table)
    private List<Alien> aliens;


    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}