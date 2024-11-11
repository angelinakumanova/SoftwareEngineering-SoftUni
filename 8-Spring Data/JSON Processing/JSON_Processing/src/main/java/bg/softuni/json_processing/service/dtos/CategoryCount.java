package bg.softuni.json_processing.service.dtos;

import java.math.BigDecimal;

public interface CategoryCount {
    String getCategory();
    int getProductsCount();
    BigDecimal getAveragePrice();
    BigDecimal getTotalRevenue();

}
