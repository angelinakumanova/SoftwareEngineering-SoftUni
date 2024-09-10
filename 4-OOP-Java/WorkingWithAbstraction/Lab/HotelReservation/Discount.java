package WorkingWithAbstraction.Lab.HotelReservation;

public enum Discount {
    VIP("VIP", 0.20), SECOND_VISIT("SecondVisit", 0.1), NONE("None", 0);

    private String name;
    private double discount;


    Discount(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

    public static Discount getType(String name) {
        for (Discount discount : Discount.values()) {
            if (name.equalsIgnoreCase(discount.name)) {
                return discount;
            }
        }
        return null;
    }
    public double getDiscount() {
        return discount;
    }
}
