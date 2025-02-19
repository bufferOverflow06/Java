package mappingRelationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Tuf");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(8);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Mac");
        l3.setModel("Pro");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("AAA");
        a1.setTech("Java");


        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("BBB");
        a2.setTech("Python");

        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("CCC");
        a3.setTech("Spring Boot");

        a1.setLaptop(Arrays.asList(l1, l2));
        a2.setLaptop(Arrays.asList(l2, l3));
        a3.setLaptop(Arrays.asList(l1));

        l1.setAliens(Arrays.asList(a1, a3));
        l2.setAliens(Arrays.asList(a1, a2));
        l3.setAliens(Arrays.asList(a2));


        // To add this we have to add @Embeddable annotation to
        // the Laptop class

//        Configuration cfg = new Configuration();
//        // we can map the class either here or in xml
//        cfg.addAnnotatedClass(testHibernate.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(mappingRelationships.Alien.class)
                .addAnnotatedClass(mappingRelationships.Laptop.class)
                .configure()
                .buildSessionFactory(); // cfg.buildSessionFactory(); // either use try-with-resuources or
        // close it
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();

        Alien a5 = session.get(Alien.class, 102);
        System.out.println(a5);

        session.close();
        sf.close();
    }
}

//output for oneToMany this will create a separate table alien_laptop which has
//no primary keys instead there will be composite keys that is two keys combined
//which will be unique
//Hibernate:
//set client_min_messages = WARNING
//Hibernate:
//alter table if exists Alien_Laptop
//drop constraint if exists FKke7dk37jcwerfmirin55a5gki
//Hibernate:
//alter table if exists Alien_Laptop
//drop constraint if exists FKf2y56ehyfym5dmcdy736otfcw
//Hibernate:
//drop table if exists Alien cascade
//Hibernate:
//drop table if exists Alien_Laptop cascade
//Hibernate:
//drop table if exists Laptop cascade
//Hibernate:
//create table Alien (
//        aid integer not null,
//        aname varchar(255),
//tech varchar(255),
//primary key (aid)
//    )
//Hibernate:
//create table Alien_Laptop (
//        Alien_aid integer not null,
//        laptops_lid integer not null unique
//)
//Hibernate:
//create table Laptop (
//        lid integer not null,
//        ram integer not null,
//        brand varchar(255),
//model varchar(255),
//primary key (lid)
//    )
//Hibernate:
//alter table if exists Alien_Laptop
//add constraint FKke7dk37jcwerfmirin55a5gki
//foreign key (laptops_lid)
//references Laptop
//Hibernate:
//alter table if exists Alien_Laptop
//add constraint FKf2y56ehyfym5dmcdy736otfcw
//foreign key (Alien_aid)
//references Alien
//Feb 19, 2025 2:42:01 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@24876a7e] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//Hibernate:
//insert
//        into
//Laptop
//        (brand, model, ram, lid)
//values
//        (?, ?, ?, ?)
//Hibernate:
//insert
//        into
//Laptop
//        (brand, model, ram, lid)
//values
//        (?, ?, ?, ?)
//Hibernate:
//insert
//        into
//Alien
//        (aname, tech, aid)
//values
//        (?, ?, ?)
//Hibernate:
//insert
//        into
//Alien_Laptop
//        (Alien_aid, laptops_lid)
//values
//        (?, ?)
//Hibernate:
//insert
//        into
//Alien_Laptop
//        (Alien_aid, laptops_lid)
//values
//        (?, ?)
//embeddable{aid=101, aname='AAA', tech='Java', laptop=[Laptop{lid=1, brand='Asus', model='Tuf', ram=16}, Laptop{lid=2, brand='Dell', model='XPS', ram=8}]}
