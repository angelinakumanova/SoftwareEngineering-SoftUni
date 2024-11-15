package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "device")
public class DeviceImportDto {
    private String brand;
    @XmlElement(name = "device-type")
    private String deviceType;
    private String model;
    private Double price;
    private Integer storage;
    @XmlElement(name = "sale-id")
    private Long saleId;

    public DeviceImportDto() {
    }
}
