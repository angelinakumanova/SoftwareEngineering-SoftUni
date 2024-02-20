package WorkingWithAbstraction.Lab.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private int multiplier;
    private double discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, int multiplier, double discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.multiplier = multiplier;
        this.discountType = discountType;
    }

    public double calculatePrice() {
        double totalPriceDays = this.pricePerDay * this.numberOfDays * multiplier;

        return totalPriceDays - (totalPriceDays * this.discountType);
    }
}
