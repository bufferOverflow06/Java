package testHibernate;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateAndDelete {
    public static void main(String args[]){
        Student s1 = new Student();

//        s1.setsName("EEE");
//        s1.setRollNo(234);
//        s1.setsAge(33);

//        same data with new rollno. for checking what happens when
//        we update the record which is not present

        s1.setsName("EEE");
        s1.setRollNo(234);
        s1.setsAge(55);

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

        // for changing the database we have to have transaction
        Transaction transaction = session.beginTransaction();
        // update
        session.merge(s1); // we can use merge to create new record or
        // update in the database

        // commit the transaction
        transaction.commit();

        session.close();
        sf.close();
        System.out.println(s1);
    }
}