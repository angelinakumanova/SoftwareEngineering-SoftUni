import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import sales.entities.Product;
import sales.entities.Sale;
import university.system.entities.Course;
import university.system.entities.Student;
import university.system.entities.Teacher;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("jpa-relations-exercise").createEntityManager();

        em.getTransaction().begin();
        // 02 - Sales
//        Sale sale = new Sale();
//        Product product = new Product();
//        sale.setProduct(product);
//
//        em.persist(product);
//        em.persist(sale);
//
//        Product product1 = new Product();
//        sale.setProduct(product1);
//        em.persist(product1);

        // 03 - University System
//        Course course = new Course();
//        course.setName("Spring Data");
//        course.setDescription("Spring Data Description");
//        course.setStartDate(LocalDate.of(2024, 10, 1));
//        course.setEndDate(LocalDate.of(2024, 11, 30));
//        course.setCredits(200);
//
//        Teacher teacher = new Teacher();
//        teacher.setFirstName("Jack");
//        teacher.setLastName("Smith");
//        teacher.setEmail("jack@gmail.com");
//        teacher.setSalaryPerHour(50);
//        course.setTeacher(teacher);
//
//
//        Student student = new Student();
//        student.setFirstName("John");
//        student.setLastName("Smith");
//
//        course.addStudent(student);
//
//        em.persist(course);
//        em.persist(student);
//        em.persist(teacher);


        em.getTransaction().commit();
        em.close();
    }
}
