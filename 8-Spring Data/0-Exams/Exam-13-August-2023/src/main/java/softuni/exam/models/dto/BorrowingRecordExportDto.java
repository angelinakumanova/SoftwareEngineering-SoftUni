package softuni.exam.models.dto;

public class BorrowingRecordExportDto {
    private String bookTitle;
    private String bookAuthor;
    private String borrowDate;
    private String libraryMemberFirstName;
    private String libraryMemberLastName;

    public BorrowingRecordExportDto() {
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getLibraryMemberFirstName() {
        return libraryMemberFirstName;
    }

    public void setLibraryMemberFirstName(String libraryMemberFirstName) {
        this.libraryMemberFirstName = libraryMemberFirstName;
    }

    public String getLibraryMemberLastName() {
        return libraryMemberLastName;
    }

    public void setLibraryMemberLastName(String libraryMemberLastName) {
        this.libraryMemberLastName = libraryMemberLastName;
    }
}
