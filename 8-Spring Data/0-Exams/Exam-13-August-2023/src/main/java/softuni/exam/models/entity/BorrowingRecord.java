package softuni.exam.models.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "borrowing_records")
public class BorrowingRecord extends BaseEntity {
    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;
    private String remarks;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private LibraryMember libraryMember;

    public BorrowingRecord() {}

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }
}
