package sales.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "stores_location")
public class StoreLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
    private Set<Sale> sales;

    public StoreLocation() {
        this.sales = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Sale> getSales() {
        return Collections.unmodifiableSet(sales);
    }

    public void addSale(Sale sale) {
        if (sale != null) {
            this.sales.add(sale);
        }
    }
}
