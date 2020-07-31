package blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class People {
    private List<Card> cards;
    protected String name;
    protected byte total;

    public People() {
        cards = new ArrayList<Card>();
        total = 0;
    }

    public Card receiveCard(Card card) {
        cards.add(card);
        total += card.getValue();
        return card;
    }

    public abstract boolean wantToCatch();

    public byte getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public void printCards(boolean showAll) {
        System.out.print("\n" + name + (name == "You" ? " have" : " have") + (cards.get(0).getValue() == 8 || cards.get(0).getValue() == 11 ? " " : " ") + cards.get(0).toString());
        for (int i = 1; i < cards.size(); i++) {
            if (showAll) {
                System.out.print(" and " + (cards.get(i).getValue() == 8 || cards.get(i).getValue() == 11 ? " " : " ") + cards.get(i).toString());
            } else {
                System.out.println(" and a hidden card.");
            }
        }
        if (showAll) {
            System.out.println(".\nYour total is " + total + ".");
        }
    }
}