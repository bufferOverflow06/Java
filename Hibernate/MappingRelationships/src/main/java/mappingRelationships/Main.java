package mappingRelationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[]){

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Tuf");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("AAA");
        a1.setTech("Java");

        a1.setLaptop(l1);
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
        session.persist(a1);

        transaction.commit();

        Alien a2 = session.get(Alien.class, 101);
        System.out.println(a2);

        session.close();
        sf.close();
    }
}