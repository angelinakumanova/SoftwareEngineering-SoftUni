package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SaleImportDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.SaleRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SaleServiceImpl implements SaleService {
    private static final String SALE_JSON_PATH = "src/main/resources/files/json/sales.json";

    private final SaleRepository saleRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        SaleImportDto[] sales = gson.fromJson(Files.newBufferedReader(Path.of(SALE_JSON_PATH)), SaleImportDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(sales).filter(s -> {
            if(!validationUtil.isValid(s) || saleRepository.findByNumber(s.getNumber()).isPresent()) {
                sb.append("Invalid sale").append(System.lineSeparator());
                return false;
            }

            return true;
        }).map(s -> modelMapper.map(s, Sale.class))
                .forEach(sale -> {
                    String formattedSale = String.format("Successfully imported sale with number %s", sale.getNumber());
                    sb.append(formattedSale).append(System.lineSeparator());
                    saleRepository.save(sale);
                });

        saleRepository.flush();
        return sb.toString();
    }

    @Override
    public String importSales() throws IOException {
        return readSalesFileContent();
    }
}
