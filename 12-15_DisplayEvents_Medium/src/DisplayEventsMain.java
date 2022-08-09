import javax.swing.*;

/**
 * Main class to run the display events
 * @version 1.0, 8 October 2021
 * @author Ben DeSollar
 */

public class DisplayEventsMain {
    /**
     * Creates an DisplayEvents object to run the JFrame GUI
     * @param args an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args) {

        DisplayEvents textFieldFrame = new DisplayEvents();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(600, 600);
        textFieldFrame.setVisible(true);

    }
}
