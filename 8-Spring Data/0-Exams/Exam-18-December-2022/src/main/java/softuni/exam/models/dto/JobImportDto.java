package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "job")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobImportDto {
    @XmlElement(name = "jobTitle")
    @NotNull
    @Length(min = 2, max = 40)
    private String title;
    @XmlElement
    @NotNull
    @Length(min = 5)
    private String description;
    @XmlElement
    @NotNull
    @DecimalMin("300.00")
    private BigDecimal salary;
    @XmlElement
    @NotNull
    @DecimalMin("10.00")
    private BigDecimal hoursAWeek;
    @XmlElement
    private Long companyId;

    public JobImportDto() {
    }

    public @NotNull @Length(min = 2, max = 40) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Length(min = 2, max = 40) String title) {
        this.title = title;
    }

    public @NotNull @Length(min = 5) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Length(min = 5) String description) {
        this.description = description;
    }

    public @NotNull @DecimalMin("300.00") BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(@NotNull @DecimalMin("300.00") BigDecimal salary) {
        this.salary = salary;
    }

    public @NotNull @DecimalMin("10.00") BigDecimal getHoursAWeek() {
        return hoursAWeek;
    }

    public void setHoursAWeek(@NotNull @DecimalMin("10.00") BigDecimal hoursAWeek) {
        this.hoursAWeek = hoursAWeek;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
