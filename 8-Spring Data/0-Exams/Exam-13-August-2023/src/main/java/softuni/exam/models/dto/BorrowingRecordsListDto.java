package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordsListDto {
    @XmlElement(name = "borrowing_record")
    List<BorrowingRecordImportDto> borrowingRecords;

    public BorrowingRecordsListDto() {
    }

    public List<BorrowingRecordImportDto> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(List<BorrowingRecordImportDto> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }
}
