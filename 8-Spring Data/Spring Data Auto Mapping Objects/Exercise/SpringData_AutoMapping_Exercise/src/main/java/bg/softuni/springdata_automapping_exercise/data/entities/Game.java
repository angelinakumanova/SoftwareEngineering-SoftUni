package bg.softuni.springdata_automapping_exercise.data.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;


}
