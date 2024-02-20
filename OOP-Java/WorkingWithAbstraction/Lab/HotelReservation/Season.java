package WorkingWithAbstraction.Lab.HotelReservation;

public enum Season {
    AUTUMN(1), SPRING(2),
    WINTER(3), SUMMER(4);

    private final int index;

    Season(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
