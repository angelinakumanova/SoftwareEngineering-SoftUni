package bg.softuni.json_processing.service.impl;

import bg.softuni.json_processing.data.entities.Category;
import bg.softuni.json_processing.data.entities.Product;
import bg.softuni.json_processing.data.entities.User;
import bg.softuni.json_processing.data.repositories.ProductRepository;
import bg.softuni.json_processing.service.CategoryService;
import bg.softuni.json_processing.service.ProductService;
import bg.softuni.json_processing.service.UserService;
import bg.softuni.json_processing.service.dtos.CategorySeedJsonDto;
import bg.softuni.json_processing.service.dtos.ProductPriceRangeDto;
import bg.softuni.json_processing.service.dtos.ProductSeedJsonDto;
import bg.softuni.json_processing.utils.ValidatorUtil;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String PRODUCTS_PATH = "src/main/resources/files/products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;

        configureMappings();
    }

    @Override
    public void seedProducts() {
        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(PRODUCTS_PATH)))) {
            ProductSeedJsonDto[] productsSeed = gson.fromJson(jsonReader, ProductSeedJsonDto[].class);

            for (ProductSeedJsonDto productSeed : productsSeed) {
                if (!validatorUtil.isValid(productSeed)) {
                    String errors = validatorUtil.validate(productSeed)
                            .stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("\n"));
                    System.out.println(("Validation errors: \n" + errors));
                    continue;
                }

                Product product = modelMapper.map(productSeed, Product.class);
                product.setBuyer(userService.getRandomUser());
                product.setSeller(userService.getRandomUser());
                product.setCategories(categoryService.getRandomCategories());
                productRepository.save(product);
            }

            productRepository.flush();
            System.out.println(productRepository.count() + " Products have been seeded");
        } catch (IOException e) {
            System.out.println("Failed to read products.json");
        }
    }

    @Override
    public boolean isImported() {
        return productRepository.count() > 0;
    }

    @Override
    public void getProductsJsonByPriceRange(double lower, double upper) {
        List<ProductPriceRangeDto> priceRangeDtos = productRepository.getProductsByPriceBetweenOrderByPriceAsc(BigDecimal.valueOf(lower), BigDecimal.valueOf(upper))
                .stream()
                .map(product -> modelMapper.map(product, ProductPriceRangeDto.class))
                .collect(Collectors.toList());

        String json =  gson.toJson(priceRangeDtos);
        Path filePath = Path.of("src/main/resources/files/products-by-price-range.json");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void configureMappings() {
        Converter<User, String> sellerConverter = context -> {
            String firstName = context.getSource().getFirstName() != null ? context.getSource().getFirstName() : "";
            String lastName = context.getSource().getLastName();

            return firstName + (firstName.isEmpty() ? "" : " ") + lastName;
        };

        modelMapper.addMappings(new PropertyMap<Product, ProductPriceRangeDto>() {
            @Override
            protected void configure() {
                using(sellerConverter).map(source.getSeller()).setSeller(null);
            }
        });
    }
}
