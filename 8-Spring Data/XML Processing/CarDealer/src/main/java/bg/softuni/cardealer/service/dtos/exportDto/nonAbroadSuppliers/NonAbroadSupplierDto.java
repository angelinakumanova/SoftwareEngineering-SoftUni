package bg.softuni.cardealer.service.dtos.exportDto.nonAbroadSuppliers;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class NonAbroadSupplierDto {
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "parts-count", isAttribute = true)
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
