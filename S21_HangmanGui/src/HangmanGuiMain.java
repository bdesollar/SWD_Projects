import javax.swing.*;

/**
 * Main class that will create a new Hangman GUI object
 * @author Ben DeSollar
 */
public class HangmanGuiMain {

    /**
     * Creates the Hangman GUI which is then run
     * @param args  an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args) {
        HangmanGUI gui = new HangmanGUI();
        gui.setTitle("Hangman");
        gui.setSize(675, 800);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
