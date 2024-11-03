package bg.softuni.usersystem.data.entities;

import bg.softuni.usersystem.data.entities.annotations.Password;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 4, max = 30)
    private String username;

    @Column(nullable = false)
    @Size(min = 6, max = 50)
    @Password(containsLowerCase = true, containsUpperCase = true, containsDigit = true, containsSpecialSymbol = true)
    private String password;

    @Column(nullable = false)
    @Email(regexp = "^[a-zA-Z0-9]+([._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(-?[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})+$",
            message = "Invalid email format")
    private String email;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;

    private int age;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "born_town_id")
    private Town bornTown;

    @ManyToOne
    @JoinColumn(name = "current_town_id")
    private Town currentTown;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums;

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public User() {
        this.friends = new HashSet<>();
        this.albums  = new HashSet<>();
    }

    public User(String username, String password, String email, LocalDateTime registeredOn, LocalDateTime lastTimeLoggedIn, int age, boolean isDeleted, Town bornTown, Town currentTown, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registeredOn = registeredOn;
        this.lastTimeLoggedIn = lastTimeLoggedIn;
        this.age = age;
        this.isDeleted = isDeleted;
        this.bornTown = bornTown;
        this.currentTown = currentTown;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @Size(min = 4, max = 30) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 4, max = 30) String username) {
        this.username = username;
    }

    public @Size(min = 6, max = 50) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, max = 50) String password) {
        this.password = password;
    }

    public @Email(regexp = "^[a-zA-Z0-9]+([._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(-?[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})+$",
            message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@Email(regexp = "^[a-zA-Z0-9]+([._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(-?[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})+$",
            message = "Invalid email format") String email) {
        this.email = email;
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    public Town getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(Town currentTown) {
        this.currentTown = currentTown;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
