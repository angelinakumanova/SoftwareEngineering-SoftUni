package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.enums.VolcanoType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VolcanoImportDto {
    @NotNull
    @Length(min = 2, max = 30)
    private String name;
    @NotNull
    @Positive
    private Integer elevation;
    private String volcanoType;
    @NotNull
    private Boolean isActive;
    private String lastEruption;
    private Integer country;

    public VolcanoImportDto() {
    }

    public @NotNull @Length(min = 2, max = 30) String getName() {
        return name;
    }

    public void setName(@NotNull @Length(min = 2, max = 30) String name) {
        this.name = name;
    }

    public @NotNull @Positive Integer getElevation() {
        return elevation;
    }

    public void setElevation(@NotNull @Positive Integer elevation) {
        this.elevation = elevation;
    }

    public String getVolcanoType() {
        return volcanoType;
    }

    public void setVolcanoType(String volcanoType) {
        this.volcanoType = volcanoType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getLastEruption() {
        return lastEruption;
    }

    public void setLastEruption(String lastEruption) {
        this.lastEruption = lastEruption;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }
}
