// Fig. 28.7: Server.java
// Server side of connectionless client/server computing with datagrams.

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * initializes and runs the server that deals with connections to the clients and runs the dealer
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Server{
    /**
     * the deck of cards to be used in the game
     */
    private static final Deck deckOfCards = new Deck();
    /**
     * an arrayList containing all the cards in the players hand
     */
    private static ArrayList<Cards> playersHand = new ArrayList<>();
    /**
     * an arrayList containing all the cards in the dealers hand
     */
    private static final ArrayList<Cards> dealersHand = new ArrayList<>();
    /**
     * the number of connections that the server has
     */
    private static int numberOfConnections = 1;
    /**
     * number of cards that have been played in the game, updated to get the next card in the deck
     */
    private static int numberOfCardsPlayed = 0;
    /**
     * a check to see if the client is still playing
     */
    private static boolean clientStillPlaying = true;

    /**
     * stores the clients in the server
     */
    private static final ClientHandler[] playersInGame = new ClientHandler[2];

    /**
     * creates the Dealer and the server. As well as the ClientHandlers to control and connect to the clients (Players)
     * @param args an array of strings that can be passed in when starting the main program
     * @throws Exception used in the catch method to catch an errors and display them
     */
    public static void main(String[] args) throws Exception {
        // Creates the thread pool
        ExecutorService service = Executors.newFixedThreadPool(3);

        try {
            System.out.println("Waiting for connections....");

            //Creating a dealer thread object.
            Dealer dealer = new Dealer();

            ServerSocket server = new ServerSocket(23530, 2);

            // allow server to accept connection
            Socket connection = server.accept();
            System.out.println("Connection " + numberOfConnections + " received from: " + connection.getInetAddress().getHostName());
            ClientHandler player1 = new ClientHandler(connection);
            playersInGame[0] = player1;


            connection = server.accept(); // allow server to accept another connection
            System.out.println("Connection " + numberOfConnections + " received from: " + connection.getInetAddress().getHostName());
            ClientHandler player2 = new ClientHandler(connection);
            playersInGame[1] = player2;

            service.execute(dealer);
            service.execute(player1);
            service.execute(player2);


        } catch (EOFException e) {
            System.out.println("\nServer terminated connection");
        } finally {
            service.shutdown();
        }
    }

    /**
     * the dealer thread that gives the dealer its cards
     */
    private static class Dealer implements Runnable {

        /**
         * the sum of the value of the cards the dealer has in its hand
         */
        private int summation;

        /**
         * constructor initializes the dealer to get two cards and gets the sum of the value of cards the dealer has in its hand
         */
        public Dealer() {
            for (int j = 0; j < 2; j++) {

                dealersHand.add(deckOfCards.getDeckOfCards().get(numberOfCardsPlayed));
                numberOfCardsPlayed++;
            }

            summation = sum(dealersHand);
        }

        /**
         * gets the sum of the value of cards the dealer has in its hand
         * @param dealerHand an arrayList of the cards in the dealers hand
         * @return the sum of the cards in the dealers hand
         */
        public int sum(ArrayList<Cards> dealerHand) {
            int sum = 0;
            for (Cards cards : dealerHand) {
                sum += cards.getValue();
            }
            return sum;
        }


        /**
         * Checks whether the sum of the cards in the dealer hand is over 17, otherwise draws another card
         */
        @Override
        public void run() {
            while (summation <= 17) {
                dealersHand.add(deckOfCards.getDeckOfCards().get(numberOfCardsPlayed));
                numberOfCardsPlayed++;
                summation = sum(dealersHand);
                System.out.println("Dealer draws a card\n");
            }
        }
    }

    /**
     * Represents a connected client
     */
    private static class ClientHandler implements Runnable {

        /**
         * the output stream
         */
        private final ObjectOutputStream out;
        /**
         * the input stream
         */
        private final ObjectInputStream in;
        /**
         * the name of the player
         */
        private final String name;
        /**
         * the sum of the cards in the players hand
         */
        private int sum;

        /**
         * Handles the clients for the server
         * @param client the socket for the client connection
         * @throws IOException exception that occurs if there is an I/O error
         */
        public ClientHandler(Socket client) throws IOException {
            this.out = new ObjectOutputStream(client.getOutputStream()); //assigns the output to the connection's output
            this.in = new ObjectInputStream(client.getInputStream()); //assigns the input to the connection's input.
            this.name = "Player " + numberOfConnections;
            numberOfConnections++; //increments everytime a ClientHandler object is created.

            //Assigns 2 cards to the Client.
            for (int i = 0; i < 2; i++) {
                playersHand.add(deckOfCards.getDeckOfCards().get(numberOfCardsPlayed));
                out.writeObject(deckOfCards.getDeckOfCards().get(numberOfCardsPlayed));
                out.flush();
                numberOfCardsPlayed++;
            }

            //Sends to the player the first cards of the dealer.
            out.writeObject(dealersHand.get(0));
            out.flush();
        }

        /**
         * runs the dealer thread that gets information from the client
         */
        @Override
        public void run() {
            try {
                //loops until the player is done with hitting
                while (clientStillPlaying) {

                    //reads the player decision
                    int choice = (Integer) in.readObject();

                    //Ends the game for the client when they want to quit and ends the run method.
                    if (choice == 1) {
                        clientStillPlaying = false;
                    }
                    // Stay gets the player's hand, computes its sum, clear the player's hand and
                    // sends the dealer's hand to the player.
                    if (choice == 3) {
                        playersHand = (ArrayList<Cards>) in.readObject();
                        for (Cards cards : playersHand) {
                            sum += cards.getValue();
                        }
                        out.writeObject(sum);
                        out.flush();
                        playersHand.clear();
                        System.out.println(name + " decided to Stay");
                        out.writeObject(dealersHand);
                        out.flush();
                    }
                    // Hit sends a card to the player and announces it in the Server terminal.
                    else if (choice == 4) {
                        Cards card_sent = deckOfCards.getDeckOfCards().get(numberOfCardsPlayed);
                        out.writeObject(card_sent);
                        numberOfCardsPlayed++;
                        System.out.println("Dealing a card to " + name);
                        out.flush();
                    }
                    // Outputs to the client when there are no more cards.
                    if (numberOfCardsPlayed == 52) {
                        out.writeObject("No more cards, restart server.");
                        out.flush();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
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