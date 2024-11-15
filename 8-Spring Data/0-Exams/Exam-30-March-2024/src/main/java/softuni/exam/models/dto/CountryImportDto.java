package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CountryImportDto {
    @NotNull
    @Length(min = 3, max = 30)
    private String name;
    @Length(min = 3, max = 30)
    private String capital;

    public CountryImportDto() {
    }

    public @NotNull @Length(min = 3, max = 30) String getName() {
        return name;
    }

    public void setName(@NotNull @Length(min = 3, max = 30) String name) {
        this.name = name;
    }

    public @Length(min = 3, max = 30) String getCapital() {
        return capital;
    }

    public void setCapital(@Length(min = 3, max = 30) String capital) {
        this.capital = capital;
    }
}
