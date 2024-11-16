package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordImportDto;
import softuni.exam.models.dto.BorrowingRecordsListDto;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.service.BookService;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {
    private final static String BORROWING_RECORDS_PATH = "src/main/resources/files/xml/borrowing-records.xml";

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookService bookService;
    private final LibraryMemberService libraryMemberService;

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookService bookService, LibraryMemberService libraryMemberService, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookService = bookService;
        this.libraryMemberService = libraryMemberService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        List<BorrowingRecordImportDto> borrowingRecords = xmlParser.fromFile(BORROWING_RECORDS_PATH, BorrowingRecordsListDto.class).getBorrowingRecords();
        StringBuilder sb = new StringBuilder();

        borrowingRecords.stream()
                .filter(br -> isValidBorrowingRecord(br, sb))
                .map(this::mapToBorrowingRecord)
                .forEach(br -> saveBorrowingRecord(br, sb));

        borrowingRecordRepository.flush();
        return sb.toString();
    }

    private void saveBorrowingRecord(BorrowingRecord br, StringBuilder sb) {
        String formatted = String.format("Successfully imported borrowing record %s - %s",
                br.getBook().getTitle(), br.getBorrowDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        sb.append(formatted).append(System.lineSeparator());
        borrowingRecordRepository.save(br);
    }

    private BorrowingRecord mapToBorrowingRecord(BorrowingRecordImportDto br) {
        BorrowingRecord borrowingRecord = modelMapper.map(br, BorrowingRecord.class);
        borrowingRecord.setBook(bookService.findByTitle(br.getBook().getTitle()).get());
        borrowingRecord.setLibraryMember(libraryMemberService.findById(br.getMember().getId()).get());

        return borrowingRecord;
    }

    private boolean isValidBorrowingRecord(BorrowingRecordImportDto br, StringBuilder sb) {
        if (!validationUtil.isValid(br) || bookService.findByTitle(br.getBook().getTitle()).isEmpty() ||
        libraryMemberService.findById(br.getMember().getId()).isEmpty()) {
            sb.append("Invalid borrowing record").append(System.lineSeparator());
            return false;
        }

        return true;
    }

    @Override
    public String exportBorrowingRecords() {
        return "";
    }
}
