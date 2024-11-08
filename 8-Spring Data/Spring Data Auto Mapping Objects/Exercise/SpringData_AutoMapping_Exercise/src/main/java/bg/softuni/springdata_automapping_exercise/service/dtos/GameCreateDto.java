package bg.softuni.springdata_automapping_exercise.service.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameCreateDto {
    @Length(min = 3, max = 100)
    @Pattern(regexp = "^[A-Z][a-z]+$")
    private String title;
    @Positive
    private BigDecimal price;
    @Positive
    private double size;
    @Length(min = 11, max = 11)
    private String trailer;
    @Pattern(regexp = "^(http://|https://).+$")
    private String imageThumbnail;
    @Length(min = 20)
    private String description;
    private LocalDate releaseDate;

    public GameCreateDto() {
    }

    public GameCreateDto(String title, BigDecimal price, double size, String trailer, String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public @Length(min = 3, max = 100) String getTitle() {
        return title;
    }

    public void setTitle(@Length(min = 3, max = 100) String title) {
        this.title = title;
    }

    public @Positive BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Positive BigDecimal price) {
        this.price = price;
    }

    @Positive
    public double getSize() {
        return size;
    }

    public void setSize(@Positive double size) {
        this.size = size;
    }

    public @Length(min = 11, max = 11) String getTrailer() {
        return trailer;
    }

    public void setTrailer(@Length(min = 11, max = 11) String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public @Length(min = 20) String getDescription() {
        return description;
    }

    public void setDescription(@Length(min = 20) String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
