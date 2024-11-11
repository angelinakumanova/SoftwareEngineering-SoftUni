package bg.softuni.json_processing.service;



public interface ProductService {
    void seedProducts();

    boolean isImported();

    void getProductsJsonByPriceRange(double lower, double upper);
}
