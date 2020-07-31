package blackjack;

import java.util.Scanner;

public class Player extends People {
    private Scanner keyboard;

    public Player() {
        super();
        name = "You";
        keyboard = new Scanner(System.in);
    }

    public boolean wantToCatch() {
        System.out.print("\nWoul you like to  \"catch\" or \"stop\": ");
        while (true) {
            String input = keyboard.next();
            if (input.equals("catch")) {
                return true;
            } else if (input.equals("stop")) {
                return false;
            } else {
                System.out.print("Type \"catch\" or \"stop\": ");
            }
        }
    }
}