import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
//        addressesWithEmployeeCount(entityManager);
//        getEmployeesWithProject(entityManager);
//        findTheLatest10Projects(entityManager);
//        increaseSalaries(entityManager);
//        findEmployeesByPattern(entityManager);
        findDepartmentsMaxSalaries(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void findDepartmentsMaxSalaries(EntityManager entityManager) {
        entityManager
                .createQuery("SELECT d.name, MAX(e.salary)" +
                        " FROM Department d JOIN d.employees e" +
                        " GROUP BY d.name" +
                        " HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(o -> {
                    String departmentName = o[0].toString();
                    String salary = o[1].toString();

                    System.out.println(departmentName + " " + salary);
                });

    }

    private static void findEmployeesByPattern(EntityManager entityManager) throws IOException {
        String pattern = READER.readLine();
        entityManager.createQuery("FROM Employee WHERE firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }

    private static void increaseSalaries(EntityManager entityManager) {
        entityManager.createQuery("FROM Employee WHERE department.name" +
                " IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultStream()
                .forEach(e -> {
                    e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    entityManager.merge(e);
                    System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary());
                });
    }

    private static void findTheLatest10Projects(EntityManager entityManager) {
        entityManager
                .createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s\n", p.getName());
                    System.out.printf("     Project Description: %s\n", p.getDescription());
                    System.out.printf("     Project startDate: %s\n", p.getStartDate()
                                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
                    System.out.printf("     Project endDate: %s\n", p.getEndDate());
                });

    }

    private static void getEmployeesWithProject(EntityManager entityManager) throws IOException {
        int inputId = Integer.parseInt(READER.readLine());

        try {
            Employee emp = entityManager.createQuery("FROM Employee WHERE id = :id", Employee.class)
                    .setParameter("id", inputId)
                    .getSingleResult();

            String[] projects = emp.getProjects()
                    .stream()
                    .map(p -> "     " + p.getName()).sorted(Comparator.naturalOrder())
                    .toArray(String[]::new);

            System.out.printf("%s %s - %s%n%s",
                        emp.getFirstName(), emp.getLastName(), emp.getJobTitle(), String.join("\n", projects));

        } catch (NoResultException e) {
            System.out.println("No employee found with id " + inputId);
        }


    }

    private static void addressesWithEmployeeCount(EntityManager entityManager) {
        entityManager
                .createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s - %d employees%n",
                                e.getText(), e.getTown().getName(), e.getEmployees().size()));

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
