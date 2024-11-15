package softuni.exam.service;

import softuni.exam.models.entity.Sale;

import java.io.IOException;
import java.util.Optional;

// TODO: Implement all methods
public interface SaleService {

    boolean areImported();

    String readSalesFileContent() throws IOException;

    String importSales() throws IOException;

    Optional<Sale> getSaleById(Long saleId);
}
