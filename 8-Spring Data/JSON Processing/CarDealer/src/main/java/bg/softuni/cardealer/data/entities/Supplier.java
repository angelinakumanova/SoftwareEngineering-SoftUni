package bg.softuni.cardealer.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table (name = "suppliers")
public class Supplier extends BaseEntity {
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;

    public Supplier() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return isImporter == supplier.isImporter && Objects.equals(name, supplier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isImporter);
    }
}
