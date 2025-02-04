package softuni.exam.models.entity;

import softuni.exam.models.enums.Genre;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Lob
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean available;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;
    @Column(nullable = false)
    private Double rating;

    public Book() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
