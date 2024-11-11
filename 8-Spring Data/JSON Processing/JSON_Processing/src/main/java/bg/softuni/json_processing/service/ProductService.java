package bg.softuni.json_processing.service;



public interface ProductService {
    void seedProducts();

    boolean isImported();

    String getProductsJsonByPriceRange(double lower, double upper);
}
