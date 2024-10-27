package relations;

import vehicle_hierarchy.table_per_class.Truck;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "full_name")
    private String fullName;

    @ManyToMany
    @JoinTable(
            name = "drivers_trucks",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "truck_id")
    )
    private Set<Truck> trucks;

    public Driver() {
        this.trucks = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addTruck(Truck truck) {
        if (truck != null) {
            this.trucks.add(truck);
        }
    }
}
