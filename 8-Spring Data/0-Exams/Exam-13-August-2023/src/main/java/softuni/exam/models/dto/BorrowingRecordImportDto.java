package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordImportDto {
    @XmlElement(name = "borrow_date")
    @NotNull
    private String borrowDate;
    @XmlElement(name = "return_date")
    @NotNull
    private String returnDate;
    @XmlElement
    private BookBRImportDto book;
    @XmlElement
    private MemberBRImportDto member;
    @XmlElement
    @Length(min = 3, max = 100)
    private String remarks;

    public BorrowingRecordImportDto() {
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public BookBRImportDto getBook() {
        return book;
    }

    public void setBook(BookBRImportDto book) {
        this.book = book;
    }

    public MemberBRImportDto getMember() {
        return member;
    }

    public void setMember(MemberBRImportDto member) {
        this.member = member;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
