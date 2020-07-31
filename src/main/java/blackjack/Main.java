package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Main game;
    private ArrayList<People> players;
    private Deck deck;

    public Main() {
        startGame();
        giveCards();
        changeShift();
        declareWinner();
        playAnother();
    }

    public static void main(String[] args) {
        game = new Main();
    }

    private void startGame() {
        deck = new Deck();
        players = new ArrayList<People>();
        players.add(new Player());
        players.add(new Dealer());

        System.out.println("===== Blackjack =====");
    }

    private void giveCards() {
        for (People player : players) {
            deck.giveInitialCards(player);
            player.printCards(player.getName().equals("You"));
        }
    }

    private void changeShift() {
        for (People player: players) {
            boolean endShift = false;
            while(!endShift) {
                player.printCards(true);
                boolean hit = player.wantToCatch();
                if (hit) {
                    deck.giveCard(player);
                    System.out.println(player.getName() + " catch a card.\n");
                    if (player.getTotal() > 21) {
                        endShift = true;
                        System.out.println(player.getName() + " exceeded.\n");
                    }
                } else {
                    endShift = true;
                    System.out.println(player.getName() + " stopped.\n");
                }
            }
        }
    }

    private void declareWinner() {
        byte highest = -1;
        byte topPlayer = -1;
        for (byte i = 0; i < players.size(); i++) {
            String name = players.get(i).getName();
            byte total = players.get(i).getTotal();

            System.out.println(name + (name.equals("You") ? " have " : " have ") + "the total of " + total + ".");

            if (total > highest && total <= 21) {
                highest = total;
                topPlayer = i;
            }
            if (total == highest && name.equals("The dealer")) {
                topPlayer = i;
            }
        }
        if (topPlayer == -1) {
            System.out.println("Everyone exceeded. Nobody won.");
        } else {
            System.out.println(players.get(topPlayer).getName() + " won!");
        }
    }

    private void playAnother() {
        System.out.print("\nPlay again? \"y\" / \"n\": ");
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            String input = keyboard.next();
            if (input.equals("y")) {
                game = new Main();
            } else if (input.equals("n")) {
                System.exit(0);
            } else {
                System.out.print("please type \"y\" or \"n\": ");
            }
        }
    }
}