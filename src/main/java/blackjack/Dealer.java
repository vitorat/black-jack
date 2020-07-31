package blackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Dealer extends People {

    public Dealer() {
        super();
        name = "The dealer";
    }

    public boolean wantToCatch() {
        if (total < 16) return true;
        if (total > 16) return false;
        if (ThreadLocalRandom.current().nextInt(0,2) == 0) return true;
        return false;
    }
}