package Lab;

import Lab.relations.Company;
import Lab.relations.PlateNumber;
import Lab.vehicle_hierarchy.table_per_class.Car;
import Lab.vehicle_hierarchy.table_per_class.Plane;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//        Car car = new Car();
//        PlateNumber plateNumber = new PlateNumber();
//        plateNumber.setNumber("332AD");
//        car.setModel("BMW X6");
//        car.setPlateNumber(plateNumber);
//        em.persist(plateNumber);
//        em.persist(car);

        Plane plane = new Plane();
        Plane plane2 = new Plane();

        Company company = new Company();
        plane.setCompany(company);
        plane2.setCompany(company);

        em.persist(company);
        em.persist(plane);
        em.persist(plane2);


        em.getTransaction().commit();

        em.close();


    }
}
