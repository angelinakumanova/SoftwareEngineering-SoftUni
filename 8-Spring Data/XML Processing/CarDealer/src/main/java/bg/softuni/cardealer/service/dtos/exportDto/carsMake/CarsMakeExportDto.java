package bg.softuni.cardealer.service.dtos.exportDto.carsMake;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "cars-by-make")
public class CarsMakeExportDto {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "car")
    private List<CarByMakeDto> cars;

    public CarsMakeExportDto() {
    }

    public CarsMakeExportDto(List<CarByMakeDto> cars) {
        this.cars = cars;
    }

    public List<CarByMakeDto> getCars() {
        return cars;
    }

    public void setCars(List<CarByMakeDto> cars) {
        this.cars = cars;
    }
}
