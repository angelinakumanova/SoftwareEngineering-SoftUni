package bg.softuni.cardealer.service.dtos.exportDto.totalSales;

import bg.softuni.cardealer.data.entities.Customer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "total-sales-by-customer")
public class SalesExportDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "customer")
    private List<CustomerSaleDto> customers;

    public SalesExportDto() {
    }

    public SalesExportDto(List<CustomerSaleDto> customers) {
        this.customers = customers;
    }

    public List<CustomerSaleDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerSaleDto> customers) {
        this.customers = customers;
    }
}
