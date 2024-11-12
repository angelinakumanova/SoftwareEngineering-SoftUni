package bg.softuni.cardealer.service.dtos.exportDto;

public class NonAbroadSupplierDto {
    private Long id;
    private String name;
    private Integer partsCount;

    public NonAbroadSupplierDto() {
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

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}
