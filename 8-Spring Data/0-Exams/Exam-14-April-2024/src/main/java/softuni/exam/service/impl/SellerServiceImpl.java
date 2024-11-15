package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerImportDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SellerServiceImpl implements SellerService {
    private static final String SELLER_JSON_PATH = "src/main/resources/files/json/sellers.json";

    private final SellerRepository sellerRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        SellerImportDto[] sellers= gson.fromJson(Files.newBufferedReader(Path.of(SELLER_JSON_PATH)), SellerImportDto[].class);
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(sellers)
                .filter(s -> {
            if(!validationUtil.isValid(s) || sellerRepository.findByLastName(s.getLastName()).isPresent()) {
                stringBuilder.append("Invalid seller").append(System.lineSeparator());
                return false;
            }

            return true;
        }).map(s -> modelMapper.map(s, Seller.class))
           .forEach(seller -> {
               stringBuilder.append(String.format("Successfully imported seller %s %s%n", seller.getFirstName(), seller.getLastName()));
               sellerRepository.save(seller);
           });

        sellerRepository.flush();


        return stringBuilder.toString();
    }

    @Override
    public String importSellers() throws IOException {
        return readSellersFromFile();
    }
}
