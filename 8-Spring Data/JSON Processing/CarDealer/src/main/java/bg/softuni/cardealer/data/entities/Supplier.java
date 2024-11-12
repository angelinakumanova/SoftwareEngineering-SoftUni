package bg.softuni.cardealer.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "suppliers")
public class Supplier extends BaseEntity {
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private Set<Part> parts;

    public Supplier() {
        this.parts = new HashSet<>();
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

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
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
