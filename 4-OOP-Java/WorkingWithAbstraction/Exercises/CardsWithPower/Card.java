package WorkingWithAbstraction.Exercises.CardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void printCard() {
        System.out.printf("Card name: %s of %s; Card power: %d%n",
                this.rank,
                this.suit,
                this.rank.getValue() + this.suit.getValue());
    }

}
