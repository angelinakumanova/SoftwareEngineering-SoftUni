package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class SaleImportDto {
    private Boolean discounted;
    @NotNull @Length(min = 7, max = 7)
    private String number;
    @NotNull
    private String saleDate;
    private int seller;

    public SaleImportDto() {
    }

    public Boolean getDiscounted() {
        return discounted;
    }

    public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
    }

    public @NotNull @Length(min = 7, max = 7) String getNumber() {
        return number;
    }

    public void setNumber(@NotNull @Length(min = 7, max = 7) String number) {
        this.number = number;
    }

    public @NotNull String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(@NotNull String saleDate) {
        this.saleDate = saleDate;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }
}
