package blackjack;

public class Card {
    private int value;

    public Card(int value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }

    public int getValue() {
        return value;
    }
}