package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyImportDto {
    @XmlElement(name = "companyName")
    @NotNull
    @Length(min = 2, max = 40)
    private String name;
    @XmlElement
    @NotNull
    private String dateEstablished;
    @XmlElement
    @NotNull
    @Length(min = 2, max = 30)
    private String website;
    @XmlElement
    private Long countryId;

    public CompanyImportDto() {
    }

    public @NotNull @Length(min = 2, max = 40) String getName() {
        return name;
    }

    public void setName(@NotNull @Length(min = 2, max = 40) String name) {
        this.name = name;
    }

    public @NotNull String getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(@NotNull String dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public @NotNull @Length(min = 2, max = 30) String getWebsite() {
        return website;
    }

    public void setWebsite(@NotNull @Length(min = 2, max = 30) String website) {
        this.website = website;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
