package bg.softuni.mvc_workshop.service.model.imports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectRootImportModel {
    @XmlElement(name = "project")
    private List<ProjectImportModel> projects;

    public ProjectRootImportModel() {}

    public List<ProjectImportModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectImportModel> projects) {
        this.projects = projects;
    }
}
