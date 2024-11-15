package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceImportDto;
import softuni.exam.models.dto.DevicesListImportDto;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private static final String DEVICE_XML_PATH = "src/main/resources/files/xml/devices.xml";

    private final DeviceRepository deviceRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public DeviceServiceImpl(DeviceRepository deviceRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.deviceRepository = deviceRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        try {
            DevicesListImportDto devices = xmlParser.fromFile(DEVICE_XML_PATH, DevicesListImportDto.class);
            List<DeviceImportDto> devicesList = devices.getDevices();

            System.out.println();
        } catch (JAXBException e) {
            System.err.println("Invalid XML file. Message: " + e.getMessage());
        }


        return "";
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        return readDevicesFromFile();
    }

    @Override
    public String exportDevices() {
        return "";
    }
}
