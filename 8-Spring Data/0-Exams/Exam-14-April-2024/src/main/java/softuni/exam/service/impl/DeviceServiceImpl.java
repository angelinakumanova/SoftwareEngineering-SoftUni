package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceExportDto;
import softuni.exam.models.dto.DeviceImportDto;
import softuni.exam.models.dto.DevicesListImportDto;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.enums.DeviceType;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {
    private static final String DEVICE_XML_PATH = "src/main/resources/files/xml/devices.xml";

    private final DeviceRepository deviceRepository;
    private final SaleService saleService;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public DeviceServiceImpl(DeviceRepository deviceRepository, SaleService saleService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.deviceRepository = deviceRepository;
        this.saleService = saleService;
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
        return new String(Files.readAllBytes(Path.of(DEVICE_XML_PATH)));
    }

    @Override
    public String importDevices() {
        try {
            DevicesListImportDto devices = xmlParser.fromFile(DEVICE_XML_PATH, DevicesListImportDto.class);
            List<DeviceImportDto> devicesList = devices.getDevices();

            StringBuilder sb = new StringBuilder();

            devicesList.stream().filter(d -> {
                if (this.deviceRepository.findByBrandAndModel(d.getBrand(), d.getModel()).isPresent()
                        || saleService.getSaleById(d.getSaleId()).isEmpty() || !validationUtil.isValid(d)) {
                    sb.append("Invalid device").append(System.lineSeparator());
                    return false;
                }

                return true;
            }).map(d -> modelMapper.map(d, Device.class)).forEach(device -> {
                String formattedDevice = String.format("Successfully imported device of type %s with brand %s",
                        device.getDeviceType().name(), device.getBrand());
                sb.append(formattedDevice).append(System.lineSeparator());
                deviceRepository.save(device);
            });

            deviceRepository.flush();
            return sb.toString();
        } catch (JAXBException e) {
            System.err.println("Invalid XML file. Message: " + e.getMessage());
        }

        return "";
    }

    @Override
    public String exportDevices() {
        StringBuilder sb = new StringBuilder();

        this.deviceRepository.findByDeviceTypeAndPriceLessThanAndStorageGreaterThanEqual(DeviceType.SMART_PHONE,1000.0, 128)
                .stream()
                .map(d -> modelMapper.map(d, DeviceExportDto.class))
                .sorted((d1, d2) -> d1.getBrand().compareToIgnoreCase(d2.getBrand()))
                .forEach(d -> {
                    String formattedDevice = String.format("Device brand: %s%n" +
                            "   *Model: %s%n" +
                            "   **Storage: %d%n" +
                            "   ***Price: %.2f", d.getBrand(), d.getModel(), d.getStorage(), d.getPrice());
                    sb.append(formattedDevice).append(System.lineSeparator());
                });

        return sb.toString();
    }
}
