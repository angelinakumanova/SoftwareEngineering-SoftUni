package JPA;


import JPA.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Smith");
        employee.setSalary(2000.00);

//        em.persist(employee);

        Employee found = em.find(Employee.class, 1);
        found.setSalary(2500.00);


        em.getTransaction().commit();
        em.close();
    }
}
