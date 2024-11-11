package bg.softuni.json_processing.data.repositories;

import bg.softuni.json_processing.data.entities.Category;
import bg.softuni.json_processing.service.dtos.CategoryCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c.name AS category, COUNT(p) AS productsCount, AVG(p.price) AS averagePrice, SUM(p.price) AS totalRevenue " +
            "FROM Category c " +
            "JOIN c.products p " +
            "GROUP BY c.id " +
            "ORDER BY COUNT(p) DESC")
    List<CategoryCount> getCategoriesWithProductsCount();
}
