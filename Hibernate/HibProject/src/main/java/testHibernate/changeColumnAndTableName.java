package testHibernate;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class changeColumnAndTableName {
    public static void main(String args[]){

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("AAA");
        a1.setTech("Java");

//        Configuration cfg = new Configuration();
//        // we can map the class either here or in xml
//        cfg.addAnnotatedClass(testHibernate.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(testHibernate.Alien.class)
                .configure()
                .buildSessionFactory(); // cfg.buildSessionFactory(); // either use try-with-resuources or
        // close it
        Session session = sf.openSession();

        session.persist(a1);

        Transaction transaction = session.beginTransaction();

        transaction.commit();

        session.close();
        sf.close();
        System.out.println(a1);
    }
}

//output
//Hibernate:
//create table Alien (
//        aid integer not null,
//        aname varchar(255),
//tech varchar(255),
//primary key (aid)
//    )
//Hibernate:
//insert
//        into
//Alien
//        (aname, tech, aid)
//values
//        (?, ?, ?)
//Alien{aid=101, aname='AAA', tech='Java'}


// if we change the
// <property name="hibernate.hbm2ddl.auto">create</property>
// then hibernate will first drop if the table exists then create a new one
