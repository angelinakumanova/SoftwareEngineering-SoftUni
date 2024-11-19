package softuni.exam.models.dto;

import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CityImportDto {
    @SerializedName("cityName")
    @NotNull @Length(min = 2, max = 60)
    private String name;
    @Length(min = 2)
    private String description;
    @NotNull @Min(500)
    private Integer population;
    private Long country;

    public CityImportDto() {}

    public @NotNull @Length(min = 2, max = 60) String getName() {
        return name;
    }

    public void setName(@NotNull @Length(min = 2, max = 60) String name) {
        this.name = name;
    }

    public @Length(min = 2) String getDescription() {
        return description;
    }

    public void setDescription(@Length(min = 2) String description) {
        this.description = description;
    }

    public @NotNull @Min(500) Integer getPopulation() {
        return population;
    }

    public void setPopulation(@NotNull @Min(500) Integer population) {
        this.population = population;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
