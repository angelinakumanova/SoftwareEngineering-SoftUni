import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import sales.entities.Product;
import sales.entities.Sale;

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


        em.getTransaction().commit();
        em.close();
    }
}
