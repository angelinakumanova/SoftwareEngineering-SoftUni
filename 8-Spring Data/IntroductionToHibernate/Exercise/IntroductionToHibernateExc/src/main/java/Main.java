import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

//        changeCasing(entityManager);
        containsEmployee(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void containsEmployee(EntityManager entityManager) throws IOException {
        String[] employeeData = READER.readLine().split("\\s+");

        List<Employee> emps = entityManager.createQuery("FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName", Employee.class)
                .setParameter("firstName", employeeData[0])
                .setParameter("lastName", employeeData[1])
                .getResultList();

        System.out.println(!emps.isEmpty() ? "Yes" : "No");
    }

    private static void changeCasing(EntityManager entityManager) {
        entityManager.createQuery("UPDATE Town SET name = UPPER(name) WHERE LENGTH(name) > 5").executeUpdate();
    }
}
