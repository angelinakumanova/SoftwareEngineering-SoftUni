package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final static String BOOK_PATH = "src/main/resources/files/json/books.json";

    private final BookRepository bookRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public BookServiceImpl(BookRepository bookRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOK_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        BookImportDto[] booksImport = gson.fromJson(readBooksFromFile(), BookImportDto[].class);
        StringBuilder sb = new StringBuilder();


        Arrays.stream(booksImport)
                .filter(b -> isValidBook(b, sb))
                .map(b -> modelMapper.map(b, Book.class))
                .forEach(book -> saveBook(book, sb));

        bookRepository.flush();
        return sb.toString();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    private void saveBook(Book book, StringBuilder sb) {
        String formattedBook = String.format("Successfully imported book %s - %s",
                book.getAuthor(), book.getTitle());

        sb.append(formattedBook).append(System.lineSeparator());
        bookRepository.save(book);
    }

    private boolean isValidBook(BookImportDto b, StringBuilder sb) {
        if (!validationUtil.isValid(b) || bookRepository.findByTitle(b.getTitle()).isPresent()) {
            sb.append("Invalid book").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
