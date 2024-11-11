package bg.softuni.json_processing.service.impl;

import bg.softuni.json_processing.data.entities.Category;
import bg.softuni.json_processing.data.repositories.CategoryRepository;
import bg.softuni.json_processing.service.CategoryService;
import bg.softuni.json_processing.service.dtos.CategorySeedJsonDto;
import bg.softuni.json_processing.utils.ValidatorUtil;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_PATH = "src/main/resources/files/categories.json";

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public void seedCategories() {
        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(CATEGORIES_PATH)))) {
            CategorySeedJsonDto[] categoriesSeed = gson.fromJson(jsonReader, CategorySeedJsonDto[].class);

            for (CategorySeedJsonDto categorySeed : categoriesSeed) {
                if (!validatorUtil.isValid(categorySeed)) {
                    String errors = validatorUtil.validate(categorySeed)
                            .stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("\n"));
                    System.out.println(("Validation errors: \n" + errors));
                    continue;
                }

                Category category = modelMapper.map(categorySeed, Category.class);
                categoryRepository.save(category);
            }

            categoryRepository.flush();
            System.out.println(categoryRepository.count() + " Categories have been seeded");
        } catch (IOException e) {
            System.out.println("Failed to read categories.json");
        }
    }

    @Override
    public boolean isImported() {
        return categoryRepository.count() > 0;
    }
}
