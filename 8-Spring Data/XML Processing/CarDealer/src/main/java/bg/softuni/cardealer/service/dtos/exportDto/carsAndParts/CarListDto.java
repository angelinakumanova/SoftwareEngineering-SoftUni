package bg.softuni.cardealer.service.dtos.exportDto.carsAndParts;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CarListDto {
    @JacksonXmlProperty(isAttribute = true)
    private String make;
    @JacksonXmlProperty(isAttribute = true)
    private String model;
    @JacksonXmlProperty(localName = "travelled_distance", isAttribute = true)
    private Long travelledDistance;

    public CarListDto() {
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
