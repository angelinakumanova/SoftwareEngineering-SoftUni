package bg.softuni.mvc_workshop.service.model.imports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyRootImportModel {
    @XmlElement(name = "company")
    private List<CompanyImportModel> companies;

    public CompanyRootImportModel() {
    }

    public List<CompanyImportModel> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyImportModel> companies) {
        this.companies = companies;
    }
}
