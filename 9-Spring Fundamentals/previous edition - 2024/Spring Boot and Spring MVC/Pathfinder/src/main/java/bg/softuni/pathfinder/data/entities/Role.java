package bg.softuni.pathfinder.data.entities;

import bg.softuni.pathfinder.data.enums.UserRoles;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private UserRoles name;

    public Role() {}

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
