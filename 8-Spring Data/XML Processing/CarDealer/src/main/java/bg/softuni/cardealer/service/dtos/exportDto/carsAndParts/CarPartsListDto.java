package bg.softuni.cardealer.service.dtos.exportDto.carsAndParts;

import java.util.List;

public class CarPartsListDto {
    private CarListDto car;
    private List<PartsListDto> parts;

    public CarPartsListDto() {
    }

    public CarListDto getCar() {
        return car;
    }

    public void setCar(CarListDto car) {
        this.car = car;
    }

    public List<PartsListDto> getParts() {
        return parts;
    }

    public void setParts(List<PartsListDto> parts) {
        this.parts = parts;
    }
}
