package bg.softuni.bookshop.service.impls;

import bg.softuni.bookshop.data.entities.Author;
import bg.softuni.bookshop.data.repositories.AuthorRepository;
import bg.softuni.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {
                   String[] split = line.split("\\s+");
                   String firstName = split[0];
                   String lastName = split[1];

                   this.authorRepository.saveAndFlush(new Author(firstName, lastName));
                });

        System.out.printf("Successfully imported %d Authors%n", authorRepository.count());
    }

    @Override
    public boolean isImported() {
        return authorRepository.count() > 0;
    }

    @Override
    public Author getRandomAuthor() {
        long id = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public void printAllAuthorsWithBooksBefore1990() {
        authorRepository.findAllByBooksReleaseDateBefore(LocalDate.of(1990, 1, 1))
                .stream()
                .filter(a -> a.getBooks().size() > 1)
                .forEach(author -> System.out.printf("%s %s%n", author.getFirstName(), author.getLastName()));
    }

    @Override
    public void printAllAuthorsByNumberOfBooks() {
        this.authorRepository.findAll()
                .stream()
                .sorted((a, b) -> b.getBooks().size() - a.getBooks().size())
                .forEach(author -> System.out.printf("%s %s -> %d%n",
                        author.getFirstName(), author.getLastName(), author.getBooks().size()));
    }


}
