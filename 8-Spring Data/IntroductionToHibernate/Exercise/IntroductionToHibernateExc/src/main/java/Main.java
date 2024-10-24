import entities.Address;
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
//        containsEmployee(entityManager);
//        employeesWithSalaryOver50k(entityManager);
//        employeesFromDepartment(entityManager);
//        addNewAddressAndUpdateEmployee(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void addNewAddressAndUpdateEmployee(EntityManager entityManager) throws IOException {
        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);

        String lastName = READER.readLine();
        List<Employee> employeeList = entityManager
                .createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList();

        if (!employeeList.isEmpty()) {
            Employee employee = employeeList.get(0);
            employee.setAddress(address);
            entityManager.persist(employee);
        }
    }

    private static void employeesFromDepartment(EntityManager entityManager) {
        entityManager.createQuery("FROM Employee WHERE department.name = 'Research and Development' " +
                                "ORDER BY salary, id", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private static void employeesWithSalaryOver50k(EntityManager entityManager) {
        entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
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
