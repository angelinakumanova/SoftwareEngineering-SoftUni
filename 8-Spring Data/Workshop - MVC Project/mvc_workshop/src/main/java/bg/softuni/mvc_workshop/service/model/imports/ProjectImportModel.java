package bg.softuni.mvc_workshop.service.model.imports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectImportModel {
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement(name = "start-date")
    private String startDate;
    @XmlElement(name = "is-finished")
    private boolean isFinished;
    @XmlElement
    private BigDecimal payment;
    @XmlElement
    private CompanyImportModel company;

    public ProjectImportModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public CompanyImportModel getCompany() {
        return company;
    }

    public void setCompany(CompanyImportModel company) {
        this.company = company;
    }
}
