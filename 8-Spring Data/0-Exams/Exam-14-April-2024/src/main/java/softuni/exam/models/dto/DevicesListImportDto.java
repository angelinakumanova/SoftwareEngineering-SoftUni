package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "devices")
public class DevicesListImportDto {
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
