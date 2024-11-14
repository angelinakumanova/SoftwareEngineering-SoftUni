package bg.softuni.cardealer.service.dtos.exportDto.carsAndParts;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "cars-and-parts")
public class CarsAndPartsExportDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "car")
    private List<CarPartsListDto> carPartsList;

    public CarsAndPartsExportDto() {
    }

    public CarsAndPartsExportDto(List<CarPartsListDto> carPartsList) {
        this.carPartsList = carPartsList;
    }

    public List<CarPartsListDto> getCarPartsList() {
        return carPartsList;
    }

    public void setCarPartsList(List<CarPartsListDto> carPartsList) {
        this.carPartsList = carPartsList;
    }
}
