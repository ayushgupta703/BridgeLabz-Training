package String;
import java.util.Scanner;

public class CardDeckGames {
	static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    public static String[] initializeDeck() {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numPlayers) {
        int totalCards = deck.length;
        if (totalCards % numPlayers != 0) {
            System.out.println("Cannot evenly distribute " + totalCards + " cards among " + numPlayers + " players.");
            return null;
        }
        int cardsPerPlayer = totalCards / numPlayers;
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        int index = 0;
        for (int p = 0; p < numPlayers; p++) {
            for (int c = 0; c < cardsPerPlayer; c++) {
                playersCards[p][c] = deck[index++];
            }
        }
        return playersCards;
    }

    public static void printPlayersCards(String[][] playersCards) {
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (String card : playersCards[i]) {
                System.out.println(" - " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] deck = initializeDeck();

        deck = shuffleDeck(deck);

        System.out.println("Enter number of players:");
        int numPlayers = sc.nextInt();

        String[][] playersCards = distributeCards(deck, numPlayers);

        if (playersCards != null) {
            printPlayersCards(playersCards);
        }

        sc.close();
    }
}
