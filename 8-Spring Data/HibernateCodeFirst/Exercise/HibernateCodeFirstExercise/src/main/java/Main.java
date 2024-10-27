import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("gringotts").createEntityManager();

        em.getTransaction().begin();



        em.getTransaction().commit();
        em.close();
    }
}
