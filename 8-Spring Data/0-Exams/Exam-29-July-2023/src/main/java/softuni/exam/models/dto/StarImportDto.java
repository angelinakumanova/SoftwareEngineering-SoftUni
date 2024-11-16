package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.enums.StarType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class StarImportDto {
    @NotNull
    @Length(min = 2, max = 30)
    private String name;
    @NotNull
    @Length(min = 6)
    private String description;
    @NotNull
    @Positive
    private Double lightYears;
    @NotNull
    private StarType starType;
    private Long constellation;

    public StarImportDto() {
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

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
