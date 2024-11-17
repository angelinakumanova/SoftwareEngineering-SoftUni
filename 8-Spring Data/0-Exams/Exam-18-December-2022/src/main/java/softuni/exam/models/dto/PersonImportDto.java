package softuni.exam.models.dto;

import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.enums.StatusType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class PersonImportDto {
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;
    @NotNull
    @Email(regexp = "^[a-zA-Z0-9_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
    private String email;
    @Length(min = 2, max = 13)
    private String phone;
    @NotNull
    private StatusType statusType;
    @SerializedName("country")
    private Long countryId;
}
