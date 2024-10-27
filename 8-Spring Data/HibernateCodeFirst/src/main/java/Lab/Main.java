package Lab;

import Lab.vehicle_hierarchy.joined.Car2;
import Lab.vehicle_hierarchy.joined.Truck2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Truck2 truck2 = new Truck2();
        Car2 car2 = new Car2();

        em.persist(truck2);
        em.persist(car2);

        em.getTransaction().commit();

        em.close();


    }
}
