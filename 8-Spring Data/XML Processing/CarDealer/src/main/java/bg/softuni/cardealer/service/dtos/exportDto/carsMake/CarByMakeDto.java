package bg.softuni.cardealer.service.dtos.exportDto.carsMake;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CarByMakeDto {
    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
    @JacksonXmlProperty(isAttribute = true)
    private String make;
    @JacksonXmlProperty(isAttribute = true)
    private String model;
    @JacksonXmlProperty(localName = "travelled-distance", isAttribute = true)
    private Long travelledDistance;

    public CarByMakeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
