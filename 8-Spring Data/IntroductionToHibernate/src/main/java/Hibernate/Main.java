package Hibernate;

import Hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
//        session.persist(student);

        Student student1 = session.get(Student.class, 1);
        System.out.println(student1);
        List<Student> students = session.createQuery("FROM Student", Student.class).list();

        students.forEach(System.out::println);
        

        session.getTransaction().commit();
        session.close();
    }
}
