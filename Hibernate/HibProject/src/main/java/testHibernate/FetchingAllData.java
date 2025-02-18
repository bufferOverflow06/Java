package testHibernate;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchingAllData {
    public static void main(String args[]){
        Student s1 = new Student();

        s1.setsName("EEE");
        s1.setRollNo(234);
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

        Student s2 = null;
        s2 = session.get(Student.class, 143);

        session.persist(s1);

        Transaction transaction = session.beginTransaction();
        transaction.commit();

        session.close();
        sf.close();
        System.out.println(s2);
    }
}