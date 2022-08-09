// Fig. 28.9: Client.java
// Client side of connectionless client/server computing with datagrams.

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * the user/client that connects to the server/dealer to play Blackjack
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Client{
    /**
     * Player's hand.
     */
    private static ArrayList<Cards> playersHand;
    /**
     * Socket to connect to server.
     */
    private Socket client;
    /**
     * Output of the client.
     */
    private static ObjectOutputStream output;
    /**
     * Input from the server.
     */
    private static ObjectInputStream input;
    /**
     * First card of the dealer.
     */
    public static String firstCardOfDealer;

    /**
     * initializes the playersHand to an empty ArrayList
     */
    public Client()
    {
        playersHand = new ArrayList<>();
    }

    /**
     * runs the client which connects to the server, gets the input and output streams, and generates the first set of cards
     * @throws IOException exception that occurs if there is an I/O error
     */
    public void runClient() throws IOException {
        try {
            connectToServer();
            getStreams();

            for (int k = 0; k < 2; k++) {
                Cards startingCards = (Cards) input.readObject();
                playersHand.add(startingCards);
            }

            Cards firstDealerCard = (Cards) input.readObject();
            firstCardOfDealer = firstDealerCard.toString();
            userPlay();

        } catch (EOFException | ClassNotFoundException eofException) {
            System.out.println("\nClient terminated connection");
        }
    }

    /**
     * connects to the server using a socket
     * @throws IOException exception that occurs if there is an I/O error
     */
    public void connectToServer() throws IOException {
        System.out.println("Attempting connection...\n");
        client = new Socket("localhost", 23530);
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
        System.out.println(client.getInetAddress());
    }

    /**
     * gets the input and output streams
     * @throws IOException exception that occurs if there is an I/O error
     */
    public void getStreams() throws IOException {

        output = new ObjectOutputStream(client.getOutputStream());
        input = new ObjectInputStream(client.getInputStream());
        System.out.println("\nGot I/O streams\n");
    }

    /**
     * interacts with the user and gets the actions, which are communicated to the dealer/server
     */
    public void userPlay() {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 1) {
            System.out.println("Please Enter Choice of Options (1: Quit, 2: Show hand, 3: Stay, 4: Hit): ");
            choice = sc.nextInt();
            try {
                // calls closeConnection() when player wants to quit the game and tells the server they are quitting
                if (choice == 1) {
                    output.writeObject(choice);
                    output.flush();
                    closeConnection();
                }
                // When the user wants to show cards
                else if (choice == 2) {
                    String hand = "";
                    int sumOfCardsInPlayersHand = 0;
                    for (Cards cards : playersHand) {
                        sumOfCardsInPlayersHand += cards.getValue();
                        hand += cards + "\n";
                    }
                    if (hand.isEmpty()) {
                        System.out.println("Hand is empty");
                    } else {
                        System.out.println("Players hand: " + hand);
                    }
                    System.out.println("Sum of cards in players hand: " + sumOfCardsInPlayersHand);
                    System.out.println("First card of the Dealer: " + firstCardOfDealer);
                }
                // User chooses to Stay
                else if (choice == 3) {

                    output.writeObject(choice);
                    output.flush();
                    output.writeObject(playersHand);
                    output.flush();

                    int playersPoints = (Integer) input.readObject();
                    System.out.println("Sum of cards in your hand is: " + playersPoints + " points");

                    playersHand.clear();
                    output.reset();

                    //gets the hand of the dealer from server
                    ArrayList<Cards> dealersCards = (ArrayList<Cards>) input.readObject();
                    String dealersCardsString = "";

                    for (Cards cards : dealersCards) {
                        dealersCardsString += cards.toString() + "\n";
                    }

                    int sumOfCards = 0;
                    for (Cards cards : dealersCards) {
                        sumOfCards += cards.getValue();
                    }
                    System.out.println("Dealers hand: " + dealersCardsString);
                    System.out.println("Sum of cards in dealer hand is: " + sumOfCards + " points");

                    if (playersPoints > sumOfCards && playersPoints <= 21) {
                        System.out.println("You have won against the dealer!");
                    } else if (playersPoints > 21) {
                        System.out.println("You have lost against the dealer");
                    } else if (sumOfCards > playersPoints && sumOfCards <= 21) {
                        System.out.println("You have lost against the dealer");
                    } else if (sumOfCards > 21) {
                        System.out.println("Dealer has lost.");

                    } else {
                        System.out.println("It's a push, you tied with the dealer");
                    }
                    choice = 1;
                    closeConnection();
                }
                // Hit
                else if (choice == 4) {
                    try {
                        output.writeObject(choice);
                        output.flush();

                        Cards newCard = (Cards) input.readObject();
                        playersHand.add(newCard);

                        System.out.println(newCard.toString() + " dealt to player");
                        System.out.println("Players Cards: ");
                        int sumOfCardsInPlayersHand = 0;
                        for(Cards cards : playersHand )
                        {
                            sumOfCardsInPlayersHand += cards.getValue();
                            System.out.println(cards);
                        }
                        System.out.println("Sum of Cards in players hand: " + sumOfCardsInPlayersHand);
                        if(sumOfCardsInPlayersHand > 21)
                        {
                            System.out.println("You lost because you went above 21 points");
                            output.writeObject(1);
                            output.flush();
                            choice = 1;
                            closeConnection();
                        }
                    } catch (ClassCastException exception) {
                        exception.printStackTrace();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Safely closes the connection with the server and the input and output streams
     */
    public void closeConnection() {
        System.out.println("\nTerminating connection\n");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
