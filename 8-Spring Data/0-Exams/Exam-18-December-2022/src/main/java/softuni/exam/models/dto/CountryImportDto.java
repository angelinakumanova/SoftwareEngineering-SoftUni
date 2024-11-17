package softuni.exam.models.dto;

import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CountryImportDto {
    @NotNull
    @Length(min = 2, max = 30)
    private String name;
    @SerializedName("countryCode")
    @NotNull
    @Length(min = 2, max = 19)
    private String code;
    @NotNull
    @Length(min = 2, max = 19)
    private String currency;

    public CountryImportDto() {
    }

    public @NotNull @Length(min = 2, max = 30) String getName() {
        return name;
    }

    public void setName(@NotNull @Length(min = 2, max = 30) String name) {
        this.name = name;
    }

    public @NotNull @Length(min = 2, max = 19) String getCode() {
        return code;
    }

    public void setCode(@NotNull @Length(min = 2, max = 19) String code) {
        this.code = code;
    }

    public @NotNull @Length(min = 2, max = 19) String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotNull @Length(min = 2, max = 19) String currency) {
        this.currency = currency;
    }
}
