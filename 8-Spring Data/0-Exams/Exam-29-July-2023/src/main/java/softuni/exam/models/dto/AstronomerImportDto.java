package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportDto {
    @XmlElement(name = "first_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;
    @XmlElement(name = "last_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;
    @XmlElement
    @NotNull
    @DecimalMin("15000")
    private BigDecimal salary;
    @XmlElement
    private String birthday;
    @XmlElement(name = "average_observation_hours")
    @NotNull
    @DecimalMin("500")
    private BigDecimal averageObservationHours;
    @XmlElement(name = "observing_star_id")
    private Long observingStarId;

    public AstronomerImportDto() {
    }

    public @NotNull @Length(min = 2, max = 30) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Length(min = 2, max = 30) String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @Length(min = 2, max = 30) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Length(min = 2, max = 30) String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @DecimalMin("15000") BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(@NotNull @DecimalMin("15000") BigDecimal salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public @NotNull @DecimalMin("500") BigDecimal getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(@NotNull @DecimalMin("500") BigDecimal averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public Long getObservingStarId() {
        return observingStarId;
    }

    public void setObservingStarId(Long observingStarId) {
        this.observingStarId = observingStarId;
    }
}
