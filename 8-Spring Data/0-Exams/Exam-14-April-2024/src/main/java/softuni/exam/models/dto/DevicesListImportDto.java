package softuni.exam.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class DevicesListImportDto {
    @XmlElement(name = "device")
    private List<DeviceImportDto> devices;

    public DevicesListImportDto() {
    }

    public List<DeviceImportDto> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceImportDto> devices) {
        this.devices = devices;
    }
}
