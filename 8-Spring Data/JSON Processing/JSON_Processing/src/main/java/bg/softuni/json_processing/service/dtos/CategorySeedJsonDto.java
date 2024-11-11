package bg.softuni.json_processing.service.dtos;

import org.hibernate.validator.constraints.Length;

public class CategorySeedJsonDto {
    @Length(min = 3, max = 15)
    private String name;

    public CategorySeedJsonDto() {
    }

    public @Length(min = 3, max = 15) String getName() {
        return name;
    }

    public void setName(@Length(min = 3, max = 15) String name) {
        this.name = name;
    }
}
