package testHibernate;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[]){
        Student s1 = new Student();

        s1.setsName("FFF");
        s1.setRollNo(25);
        s1.setsAge(23);

//        Configuration cfg = new Configuration();
//        // we can map the class either here or in xml
//        cfg.addAnnotatedClass(testHibernate.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(testHibernate.Student.class)
                .configure()
                .buildSessionFactory(); // cfg.buildSessionFactory(); // either use try-with-resuources or
        // close it
         Session session = sf.openSession();

//        session.persist(s1);

        // deleting the record
        s1 = session.get(Student.class, 123);

        Transaction transaction = session.beginTransaction();

        session.remove(s1);

        transaction.commit();

        session.close();
        sf.close();
        System.out.println(s1);
    }
}