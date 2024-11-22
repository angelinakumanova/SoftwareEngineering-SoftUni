package bg.softuni.mvc_workshop.service.model.exports;

public class EmployeeAboveExportModel {
    private String fullName;
    private Integer age;
    private String projectName;

    public EmployeeAboveExportModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
