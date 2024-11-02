package bg.softuni.bookshop.service.impls;

import bg.softuni.bookshop.data.entities.Author;
import bg.softuni.bookshop.data.entities.Book;
import bg.softuni.bookshop.data.entities.Category;
import bg.softuni.bookshop.data.entities.enums.AgeRestriction;
import bg.softuni.bookshop.data.entities.enums.EditionType;
import bg.softuni.bookshop.data.repositories.AuthorRepository;
import bg.softuni.bookshop.data.repositories.BookRepository;
import bg.softuni.bookshop.service.AuthorService;
import bg.softuni.bookshop.service.BookService;
import bg.softuni.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final String AUTHORS_PATH = "src/main/resources/files/books.txt";
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {
                    String[] data = line.split("\\s+");

                    Author author = authorService.getRandomAuthor();
                    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
                    LocalDate releaseDate = LocalDate.parse(data[1],
                            DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int copies = Integer.parseInt(data[2]);
                    BigDecimal price = new BigDecimal(data[3]);
                    AgeRestriction ageRestriction = AgeRestriction
                            .values()[Integer.parseInt(data[4])];
                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));
                    Set<Category> categories = categoryService.getRandomCategories();

                    bookRepository.saveAndFlush(new Book(
                            ageRestriction, copies, editionType, price, releaseDate, title, author, categories
                    ));
                });

        System.out.printf("Successfully imported %d books.\n", bookRepository.count());
    }

    @Override
    public boolean isImported() {
        return bookRepository.count() > 0;
    }

    @Override
    public void findAllBooksAfter2000() {
        this.bookRepository.findAllByReleaseDateAfter(LocalDate.of(2000, 12, 31))
                .forEach(b -> System.out.printf("%s%n", b.getTitle()));
    }
}
