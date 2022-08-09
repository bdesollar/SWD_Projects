import java.io.Serializable;

/**
 * card class has the cards number, type, and value in Blackjack
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Cards implements Serializable {

    /**
     * the number on the card
     */
    String numberOnCard;
    /**
     * the type of card, i.e. Heart, Spade, Club, or Diamond
     */
    String type;
    /**
     * Value of the card in Blackjack
     */
    int value;

    /**
     * Constructor initializes the cards number, type, and value in Blackjack
     * @param numberOnCard number on card
     * @param type type of card, i.e. Heart, Spade, Club, or Diamond
     * @param value the value of the card in Blackjack
     */
    public Cards(String numberOnCard,String type, int value)
    {
        this.numberOnCard=numberOnCard;
        this.type=type;
        this.value = value;
    }

    /**
     * gets the value of the card in Blackjack
     * @return he value of the card in Blackjack
     */
    public int getValue() {
        return value;
    }

    /**
     * sets the value of the card in Blackjack
     * @param value the value of the card in Blackjack
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * overrides the toString method to have a custom string outputted when the object is called in a string
     * @return a string that contains the cards number and type
     */
    @Override
    public String toString()
    {
        return this.numberOnCard + " of " + this.type;
    }
}

