package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyListImportDto {
    @XmlElement(name = "company")
    private List<CompanyImportDto> companies;

    public CompanyListImportDto() {
    }

    public List<CompanyImportDto> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyImportDto> companies) {
        this.companies = companies;
    }
}
