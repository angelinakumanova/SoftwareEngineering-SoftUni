package sales.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Double quantity;

    private BigDecimal price;

    @OneToMany(mappedBy = "product", targetEntity = Sale.class)
    private Set<Sale> sales;

    public Product() {
        this.sales = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Sale> getSales() {
        return Collections.unmodifiableSet(this.sales);
    }

    public void addSale(Sale sale) {
        if (sale != null) {
            this.sales.add(sale);
        }
    }
}
