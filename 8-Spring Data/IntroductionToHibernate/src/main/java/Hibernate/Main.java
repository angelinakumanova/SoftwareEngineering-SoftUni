package Hibernate;

import Hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setName("Jack");
        student.setAge(22);
        session.persist(student);

        session.getTransaction().commit();
        session.close();
    }
}
