package bg.softuni.cardealer.service.dtos.exportDto.orderedCustomers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "customer")
public class OrderedCustomerDto {

    private Long id;
    private String name;
    @JacksonXmlProperty(localName = "birth-date")
    private String birthDate;
    @JacksonXmlProperty(localName = "is-young-driver")
    private boolean isYoungDriver;

    public OrderedCustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }
    @JsonIgnore
    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
