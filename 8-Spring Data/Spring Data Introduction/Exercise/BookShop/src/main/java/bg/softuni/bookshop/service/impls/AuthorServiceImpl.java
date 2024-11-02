package bg.softuni.bookshop.service.impls;

import bg.softuni.bookshop.data.entities.Author;
import bg.softuni.bookshop.data.repositories.AuthorRepository;
import bg.softuni.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
}
