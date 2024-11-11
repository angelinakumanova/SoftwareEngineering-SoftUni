package bg.softuni.cardealer.service.dtos;

public class CreateSupplierJsonDto {
    private String name;
    private boolean isImporter;

    public CreateSupplierJsonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
