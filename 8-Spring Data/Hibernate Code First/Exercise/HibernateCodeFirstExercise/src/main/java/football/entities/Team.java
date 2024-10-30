package football.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    
}
