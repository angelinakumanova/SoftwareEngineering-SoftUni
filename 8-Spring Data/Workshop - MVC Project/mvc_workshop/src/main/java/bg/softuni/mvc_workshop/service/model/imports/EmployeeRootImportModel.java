package bg.softuni.mvc_workshop.service.model.imports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeRootImportModel {
    @XmlElement(name = "employee")
    private List<EmployeeImportModel> employees;

    public EmployeeRootImportModel() {}

    public List<EmployeeImportModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeImportModel> employees) {
        this.employees = employees;
    }
}
