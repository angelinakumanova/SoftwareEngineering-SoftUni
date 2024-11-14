package bg.softuni.cardealer.service.dtos.exportDto.nonAbroadSuppliers;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "non-abroad-suppliers")
public class SuppliersExportDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "supplier")
    private List<NonAbroadSupplierDto> nonAbroadSuppliers;

    public SuppliersExportDto() {
    }

    public SuppliersExportDto(List<NonAbroadSupplierDto> nonAbroadSuppliers) {
        this.nonAbroadSuppliers = nonAbroadSuppliers;
    }

    public List<NonAbroadSupplierDto> getNonAbroadSuppliers() {
        return nonAbroadSuppliers;
    }

    public void setNonAbroadSuppliers(List<NonAbroadSupplierDto> nonAbroadSuppliers) {
        this.nonAbroadSuppliers = nonAbroadSuppliers;
    }
}
