package blackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    public Card drawNextCard() {
        int value = ThreadLocalRandom.current().nextInt(2,12);
        return new Card(value);
    }

    public void giveCard(People people) {
        people.receiveCard(drawNextCard());
    }

    public void giveInitialCards(People people) {
        giveCard(people);
        giveCard(people);
    }
}