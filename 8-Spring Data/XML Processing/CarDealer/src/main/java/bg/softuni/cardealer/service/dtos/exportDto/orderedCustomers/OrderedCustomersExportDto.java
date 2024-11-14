package bg.softuni.cardealer.service.dtos.exportDto.orderedCustomers;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "ordered-customers")
public class OrderedCustomersExportDto {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "customer")
    List<OrderedCustomerDto> orderedCustomers;

    public OrderedCustomersExportDto() {

    }

    public OrderedCustomersExportDto(List<OrderedCustomerDto> orderedCustomers) {
        this.orderedCustomers = orderedCustomers;
    }

    public List<OrderedCustomerDto> getOrderedCustomers() {
        return orderedCustomers;
    }

    public void setOrderedCustomers(List<OrderedCustomerDto> orderedCustomers) {
        this.orderedCustomers = orderedCustomers;
    }
}
