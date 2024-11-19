package softuni.exam.models.dto;

import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CountryImportDto {
    @SerializedName("countryName")
    @NotNull @Length(min = 2, max = 60)
    private String name;
    @NotNull @Length(min = 2, max = 20)
    private String currency;

    public CountryImportDto() {}

    public @NotNull @Length(min = 2, max = 60) String getName() {
        return name;
    }

    public void setName(@NotNull @Length(min = 2, max = 60) String name) {
        this.name = name;
    }

    public @NotNull @Length(min = 2, max = 20) String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotNull @Length(min = 2, max = 20) String currency) {
        this.currency = currency;
    }
}
