package bg.softuni.cardealer.service.dtos.exportDto.salesDiscount;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "sales-discount")
public class SalesExportDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "sale")
    private List<SaleDiscountDto> saleDiscount;

    public SalesExportDto() {
    }

    public SalesExportDto(List<SaleDiscountDto> saleDiscount) {
        this.saleDiscount = saleDiscount;
    }

    public List<SaleDiscountDto> getSaleDiscount() {
        return saleDiscount;
    }

    public void setSaleDiscount(List<SaleDiscountDto> saleDiscount) {
        this.saleDiscount = saleDiscount;
    }
}
