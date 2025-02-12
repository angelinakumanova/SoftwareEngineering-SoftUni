package com.paintingscollectors.web.dto;

import com.paintingscollectors.painting.model.Style;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreatePaintingRequest {

    @NotNull(message = "Name must NOT be null!")
    @Size(min = 5, max = 40, message = "Name length must be between 5 and 40 characters!")
    private String name;

    @NotNull(message = "Author must NOT be null!")
    @Size(min = 5, max = 30, message = "Name length must be between 5 and 30 characters!")
    private String author;

    @NotNull(message = "Image URL must NOT be null!")
    @URL
    private String imageUrl;

    @NotNull(message = "Style must NOT be null!")
    private Style style;
}
