// Todo
// level one and level two cache working
// level one cache by default we is present in hibernate
// @OneToMany(fetch = FetchType.EAGER) by default it will be FetchType.Lazy
package mappingRelationships;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;
//    @OneToOne
//        - laptop is separate entity
//    @OneToMany(mappedBy = "alien")
    @ManyToMany
    private List<Laptop> laptops;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptops = laptop;
    }

    @Override
    public String toString() {
        return "embeddable{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}