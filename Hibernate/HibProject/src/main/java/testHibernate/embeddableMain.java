package testHibernate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Embeddable
public class embeddableMain {
    public static void main(String args[]){

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Tuf");
        l1.setRam(16);

        embeddable a1 = new embeddable();
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
                .addAnnotatedClass(testHibernate.embeddable.class)
                .configure()
                .buildSessionFactory(); // cfg.buildSessionFactory(); // either use try-with-resuources or
        // close it
        Session session = sf.openSession();

        session.persist(a1);

        Transaction transaction = session.beginTransaction();

        transaction.commit();

        embeddable a2 = session.get(embeddable.class, 101);
        System.out.println(a2);

        session.close();
        sf.close();
    }
}
