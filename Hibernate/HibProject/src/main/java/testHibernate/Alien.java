package testHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// We can change the entity name using @Entity(name="alien_table")
// or
@Entity
// we can change the table name as
//@Table(name="alien_table")
public class Alien {
    @Id
    private int aid;
    // We can change the column name as
//    @Column(name="alien_name")
    private String aname;
    // We can ignore this column from the database using
    // @Transient
    private String tech;

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

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}