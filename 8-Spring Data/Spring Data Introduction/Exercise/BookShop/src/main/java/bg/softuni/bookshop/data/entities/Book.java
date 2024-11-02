package bg.softuni.bookshop.data.entities;

import bg.softuni.bookshop.data.entities.enums.AgeRestriction;
import bg.softuni.bookshop.data.entities.enums.EditionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "books")
public class Book extends BaseEntity {
    @Column(name = "age_restriction", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    @Column(nullable = false)
    private int copies;

    @Column(length = 1000)
    private String description;

    @Column(name = "edition_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(length = 50, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories;

    public Book() {
        this.categories = new HashSet<>();
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(categories);
    }

    public void addCategory(Category category) {
        if (category != null) {
            this.categories.add(category);
        }
    }
}
