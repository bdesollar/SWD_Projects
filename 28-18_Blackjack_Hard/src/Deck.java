import java.util.ArrayList;
import java.util.Collections;

/**
 * deck of cards to be used in the game
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Deck {

    /**
     * an arrayList of Type cards in which to store all the Cards in the deck
     */
    private final ArrayList<Cards> deckOfCards;

    /**
     * gets the deck of cards
     * @return the deck of cards
     */
    public ArrayList<Cards> getDeckOfCards() {
        return deckOfCards;
    }

    /**
     * constructor initializes and places all the cards in the deck
     */
    public Deck()
    {
        deckOfCards = new ArrayList<>();

        // Clubs
        deckOfCards.add(new Cards("Two","Club", 2));
        deckOfCards.add(new Cards("Three","Club", 3));
        deckOfCards.add(new Cards("Four","Club", 4));
        deckOfCards.add(new Cards("Five","Club", 5));
        deckOfCards.add(new Cards("Six","Club", 6));
        deckOfCards.add(new Cards("Seven","Club", 7));
        deckOfCards.add(new Cards("Eight","Club", 8));
        deckOfCards.add(new Cards("Nine","Club", 9));
        deckOfCards.add(new Cards("Ten","Club", 10));
        deckOfCards.add(new Cards("Jack","Club", 10));
        deckOfCards.add(new Cards("Queen","Club", 10));
        deckOfCards.add(new Cards("King","Club", 10));
        deckOfCards.add(new Cards("Ace","Club", 1));

        // Diamonds
        deckOfCards.add(new Cards("Two","Diamonds", 2));
        deckOfCards.add(new Cards("Three","Diamonds", 3));
        deckOfCards.add(new Cards("Four","Diamonds", 4));
        deckOfCards.add(new Cards("Five","Diamonds", 5));
        deckOfCards.add(new Cards("Six","Diamonds", 6));
        deckOfCards.add(new Cards("Seven","Diamonds", 7));
        deckOfCards.add(new Cards("Eight","Diamonds", 8));
        deckOfCards.add(new Cards("Nine","Diamonds", 9));
        deckOfCards.add(new Cards("Ten","Diamonds", 10));
        deckOfCards.add(new Cards("Jack","Diamonds", 10));
        deckOfCards.add(new Cards("Queen","Diamonds", 10));
        deckOfCards.add(new Cards("King","Diamonds", 10));
        deckOfCards.add(new Cards("Ace","Diamonds", 1));

        // Hearts
        deckOfCards.add(new Cards("Two","Hearts", 2));
        deckOfCards.add(new Cards("Three","Hearts", 3));
        deckOfCards.add(new Cards("Four","Hearts", 4));
        deckOfCards.add(new Cards("Five","Hearts", 5));
        deckOfCards.add(new Cards("Six","Hearts", 6));
        deckOfCards.add(new Cards("Seven","Hearts", 7));
        deckOfCards.add(new Cards("Eight","Hearts", 8));
        deckOfCards.add(new Cards("Nine","Hearts", 9));
        deckOfCards.add(new Cards("Ten","Hearts", 10));
        deckOfCards.add(new Cards("Jack","Hearts", 10));
        deckOfCards.add(new Cards("Queen","Hearts", 10));
        deckOfCards.add(new Cards("King","Hearts", 10));
        deckOfCards.add(new Cards("Ace","Hearts", 1));

        // Spades
        deckOfCards.add(new Cards("Two","Spades", 2));
        deckOfCards.add(new Cards("Three","Spades", 3));
        deckOfCards.add(new Cards("Four","Spades", 4));
        deckOfCards.add(new Cards("Five","Spades", 5));
        deckOfCards.add(new Cards("Six","Spades", 6));
        deckOfCards.add(new Cards("Seven","Spades", 7));
        deckOfCards.add(new Cards("Eight","Spades", 8));
        deckOfCards.add(new Cards("Nine","Spades", 9));
        deckOfCards.add(new Cards("Ten","Spades", 10));
        deckOfCards.add(new Cards("Jack","Spades", 10));
        deckOfCards.add(new Cards("Queen","Spades", 10));
        deckOfCards.add(new Cards("King","Spades", 10));
        deckOfCards.add(new Cards("Ace","Spades", 1));

        // Shuffles the deck.
        Collections.shuffle(deckOfCards);
    }
}
