package bg.softuni.mvc_workshop.service.model.imports;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyImportModel {
    @XmlAttribute
    private String name;

    public CompanyImportModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
