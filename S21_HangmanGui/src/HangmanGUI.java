// Developer: Ben DeSollar

// '*' at end just means to import entire package, so I don't have to import all types of classes individually
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// Gets rid of all the
//@SuppressWarnings("ALL")

/**
 * This class creates and implements a Hangman GUI based upon the JFrame Library
 * @author Ben DeSollar
 *
 */
public class HangmanGUI extends JFrame {

    /**
     * Stores the letters that the user has guessed
     */
    private final ArrayList<String> letters_used = new ArrayList<String>();
    /**
     * The number of letters that have been guessed correctly
     */
    int num_of_guesses_correct = 0;
    /**
     * the x position on the JFrame to display letters guessed wrong
     */
    int x_for_letters_guessed_wrong = 50;
    /**
     * the y position on the JFrame to display letters guessed wrong
     */
    int y_for_letters_guessed_wrong = 575;
    /**
     * the first x position of the line to be drawn for the letters guessed correctly to be put on
     */
    int x1_letter_line_spot = 30;
    /**
     * the second x position of the line to be drawn for the letters guessed correctly to be put on
     */
    int x2_letter_line_spot = 75;
    /**
     * the y position of the line to be drawn for the letters guessed correctly to be put on
     * (Is the same for both) because the line is straight horizontal
     */
    int y_letter_line_spot = 400;
    /**
     * the x position on the JFrame to display letters guessed correctly
     */
    int x_letter_spot = 40;
    /**
     * the y position on the JFrame to display letters guessed correctly
     */
    int y_letter_spot = 400;
    /**
     * how many characters are in the word to guess excluding spaces;
     */
    // Used to check how many characters are in the word to guess excluding spaces;
    int word_length;
    /**
     * the field for the word that the user has to enter to guess
     */
    private final JPasswordField guess_word_field;
    /**
     * label that displays "Enter Letter"
     */
    private final JLabel enter_letter_text;
    /**
     * label that displays "Enter Word"
     */
    private final JLabel enter_word_text;
    /**
     * the field for the letter the user is using to guess the word
     */
    private final JTextField guess_letter_field;
    /**
     * button the user will press to enter the word to guess
     */
    private final JButton enter_word_button;
    /**
     * button the user will press to enter the letter the guessed
     */
    private final JButton enter_letter_button;
    /**
     * word that the user inputs to have another user guess
     */
    private String word_to_guess;
    /**
     * is used to check if a user has entered a word to guess
     */
    private boolean word_entered;
    /**
     * the number of guesses that the user has left to guess the letter before they lose
     */
    int num_of_guesses_left;
    /**
     * is used to check if the game was started by checking if the user already entered a word to guess
     */
    boolean game_started = false;
    /**
     * used to check whether the player has won or lost the game
     */
    boolean game_over = false;
    /**
     * stores the letters that the user guessed that were in the word to guess
     */
    ArrayList<String> letters_guessed_correct = new ArrayList<String>();
    /**
     * stores the letters that the user guessed that were not in the word to guess
     */
    ArrayList<String> letters_guessed_wrong = new ArrayList<String>();

    /**
     * the default constructor sets the layout and adds the fields to the GUI
     */
    public HangmanGUI() {
        setLayout(new FlowLayout());

        enter_letter_text = new JLabel("Enter Word Here: ");
        add(enter_letter_text);

        guess_word_field = new JPasswordField(8);
        add(guess_word_field);

        KeyHandler handler = new KeyHandler();
        guess_word_field.addKeyListener(handler);


        enter_word_button = new JButton("Enter Word");
        add(enter_word_button);

        ButtonHandler buttonHandler = new ButtonHandler();
        enter_word_button.addActionListener(buttonHandler);

        enter_word_text = new JLabel("Enter Letter Here");
        add(enter_word_text);

        guess_letter_field = new JTextField(2);
        add(guess_letter_field);
        guess_letter_field.addKeyListener(handler);

        enter_letter_button = new JButton("Enter Letter");
        add(enter_letter_button);
        enter_letter_button.addActionListener(buttonHandler);


    }


    /**
     * Draws all the objects to the screen based on the users input
     * @param g  a Graphics object that is utilized to paint GUI objects to the screen
     *
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D guesses_graphics = (Graphics2D) g;

        if(!game_started && !word_entered) {
            num_of_guesses_left = 7;
            num_of_guesses_correct = 0;

        }
        else if(num_of_guesses_left != 0 && !game_over) {
            // Starting positions for the letters that were guessed wrong to be displayed
            x_for_letters_guessed_wrong = 50;
            y_for_letters_guessed_wrong = 575;
            guesses_graphics.setColor(Color.black);
            guesses_graphics.setFont(new Font("TimesRoman", Font.PLAIN, 16));
            guesses_graphics.drawString("Number of Guesses Left: 6", 295, 130);
            // Drawing Hangman and his body
            // Hang Base
            g2.drawLine(225, 275, 285, 275);
            // Hang vertical support beam
            g2.drawLine(255, 275, 255, 115);
            // Hang horizontal support beam
            g2.drawLine(165, 115, 255, 115);
            // Hang-rope
            g2.drawLine(165, 115, 165, 155);

            x1_letter_line_spot = 30;
            x2_letter_line_spot = 75;
            x_letter_spot = 50;
            y_letter_spot = 395;
            y_letter_line_spot = 400;
            String[] words = word_to_guess.split(" ");
            int current_word = 0;

            for (int i = 0; i < word_to_guess.length(); i++) {
                Graphics2D letterLineGraphics = (Graphics2D) g;
                if (x1_letter_line_spot <= 565 && x2_letter_line_spot <= 565 && !(String.valueOf(word_to_guess.charAt(i)).equals(" "))) {
                    letterLineGraphics.drawLine(x1_letter_line_spot, y_letter_line_spot, x2_letter_line_spot, y_letter_line_spot);
                    x1_letter_line_spot += 60;
                    x2_letter_line_spot += 60;
                } else if (String.valueOf(word_to_guess.charAt(i)).equals(" ")) {
                    current_word += 1;
                    if (words[current_word].length() * 60 <= (565 - x2_letter_line_spot)) {
                        x1_letter_line_spot += 60;
                        x2_letter_line_spot += 60;
                    } else {
                        y_letter_line_spot += 75;
                        x1_letter_line_spot = 30;
                        x2_letter_line_spot = 75;
                    }
                } else {
                    y_letter_line_spot += 75;
                    x1_letter_line_spot = 30;
                    x2_letter_line_spot = 75;
                    letterLineGraphics.drawLine(x1_letter_line_spot, y_letter_line_spot, x2_letter_line_spot, y_letter_line_spot);
                }
            }
            int y = y_letter_line_spot + 50;
            g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2.drawString("Letters Guessed So Far: ", 45, y);
            if(game_started) {
                String s = guess_letter_field.getText();
                s = s.toLowerCase();
                if (game_started && !(s.equals(""))) {
                    y_for_letters_guessed_wrong = 100 + y_letter_line_spot;
                    // Checks if the letter can be used by the function guess letter
                    boolean has_letter;
                    // getPassword method returns a char[] so it has to grab the char[] and then the program
                    // converts it into a String by casting a string on it
                    String game_result = "";
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 28));
                    // Checks if the letter was already guessed
                    if (letters_used.contains(s)) {
                        System.out.println("Already guessed the letter " + s);
                        has_letter = false;
                    } else {
                        letters_used.add(s);
                        if (word_to_guess.contains(s)) {
                            letters_guessed_correct.add(s);
                            has_letter = true;
                        } else {
                            letters_guessed_wrong.add(s);
                            has_letter = false;
                        }
                    }
//              String string1 = "software design";
                    // Draws and redraws all the letters guessed right
                    int i;
                    int k = 0;
                    num_of_guesses_correct = 0;
                    for (i = 0; i < word_to_guess.length(); i++) {
                        if (letters_guessed_correct.contains(String.valueOf(word_to_guess.charAt(i)))) {
                            x_letter_spot = 50 + (i * 60);
                            num_of_guesses_correct += 1;
                            if (x_letter_spot <= 565) {
                                g.drawString(String.valueOf(word_to_guess.charAt(i)), x_letter_spot, y_letter_spot);
                            } else {
                                if (k == 0) {
                                    y_letter_spot += 75;
                                    k += 1;
                                }
                                x_letter_spot -= 550;
                                g.drawString(String.valueOf(word_to_guess.charAt(i)), x_letter_spot, y_letter_spot);
                            }
                        }
                    }
                    // Draws and redraws all the letter guesses wrong
                    y_for_letters_guessed_wrong = y_letter_line_spot + 125;
                    for (String value : letters_guessed_wrong) {
                        if (x_for_letters_guessed_wrong <= 565) {
                            g.drawString(value, x_for_letters_guessed_wrong, y_for_letters_guessed_wrong);
                            x_for_letters_guessed_wrong += 60;
                        } else {
                            y_for_letters_guessed_wrong += 75;
                            x_for_letters_guessed_wrong = 45;
                            g.drawString(value, x_for_letters_guessed_wrong, y_for_letters_guessed_wrong);
                        }
                    }
                    // Checks if the letter is correct and the number of guesses that were correct were within range of the amount of guesses the user can get
                    // right before winning
                    if (has_letter && num_of_guesses_correct <= word_length) {
                        if (num_of_guesses_correct == word_length) {
//                        System.out.println("You won!");
                            game_result = "You Won";
                            game_over = true;
//                        g.setColor(getBackground());
//                        g.fillRect(0, 0, 625, 750);
//                        g.setColor(Color.black);
//                        g2.setFont(new Font("TimesRoman", Font.PLAIN, 35));
//                        g2.drawString("You Won", 200, 300);
                        }
                    } else {
                        System.out.println("Letter was incorrect, please try again");
                        num_of_guesses_left--;
                        if (num_of_guesses_left == 0) {
                            System.out.println("You lost!");
                            game_started = false;
                            game_over = true;
                            game_result = "You Lost";
                        }
                    }
                    if (!(game_over)) {
                        g2.setColor(getBackground());
                        // Fills the spot where it says the number of guesses left so that it can redraw a new string with the current number of guesses left
                        g2.fillRect(295, 100, 250, 50);
                        g2.setColor(Color.black);
                        guesses_graphics.setFont(new Font("TimesRoman", Font.PLAIN, 16));
                        guesses_graphics.drawString("Number of Guesses Left: " + (num_of_guesses_left - 1), 295, 130);
                        // Draws the body parts according to how many guesses are left (Have to draw everything over again due to the repaint method)
                        if (num_of_guesses_left <= 6) {
                            // Head
                            g2.drawOval(147, 155, 35, 35);
                        }
                        if (num_of_guesses_left <= 5) {
                            // Body
                            g2.drawLine(165, 190, 165, 230);
                        }
                        if (num_of_guesses_left <= 4) {
                            // Left arm
                            g2.drawLine(145, 215, 165, 195);
                        }
                        if (num_of_guesses_left <= 3) {
                            // Right arm
                            g2.drawLine(165, 195, 185, 215);
                        }
                        if (num_of_guesses_left <= 2) {
                            // Left leg
                            g2.drawLine(145, 255, 165, 230);
                        }
                        if (num_of_guesses_left <= 1) {
                            // Right leg
                            g2.drawLine(165, 230, 185, 255);
                            game_over = true;
                            game_result = "You Lost";
                        }
                        guess_letter_field.setText("");
                    }
                    // Did not use an else here due to having to check if the game was over when a user lost because of the
                    // number of guesses having to be one off
                    if (game_over) {
                        // Fills the screen with the same background so that everything on the screen is cleared away
                        g.setColor(getBackground());
                        g.fillRect(0, 0, 625, 750);
                        g.setColor(Color.black);
                        g2.setFont(new Font("TimesRoman", Font.PLAIN, 35));
                        g2.drawString(game_result, 175, 300);
                    }
                }
            }
        }
    }

    /**
     * Handles Key events that occur on the JFrame GUI
     */
    private class KeyHandler implements KeyListener {
        // handle press of any key

        /**
         * Handles the event of when a key is pressed
         * @param event    an object of the key that was pressed
         */
        @Override
        public void keyPressed(KeyEvent event) {
            // Checks if the enter key was pressed
            if ("Enter".equals(KeyEvent.getKeyText(event.getKeyChar()))) {
                // repaint call preforms a request to redraw the component so that new things can be added
                if(!word_entered) {
                    word_entered = true;
                    word_to_guess = new String(guess_word_field.getPassword());
                    guess_word_field.setEditable(false);
                    word_to_guess = word_to_guess.toLowerCase();
                    String wordToGuessWithoutSpaces = word_to_guess;
                    wordToGuessWithoutSpaces = wordToGuessWithoutSpaces.replaceAll(" ", "");
                    word_length = wordToGuessWithoutSpaces.length();
                    repaint();
                }
                else {
                    if (!game_started){
                        game_started = true;
                        repaint();
                    }
                    else{
                        repaint();
                    }
                }
            }
        }

        /**
         * Handles when a key is released
         * @param event    an object of the key that was pressed
         */
        // handle release of any key
        @Override
        public void keyReleased(KeyEvent event) {

        }

        /**
         * Handles when an action key is pressed
         * @param event    an object of the key that was pressed
         */
        // handle press of an action key
        @Override
        public void keyTyped(KeyEvent event) {

        }
    }

    /**
     * Class that handles when a button is pressed
     */
    // inner class for button event handling
    private class ButtonHandler implements ActionListener
    {
        /**
         * Handles when a button is pressed
         * @param event    an object of the button that was pressed
         */
        // handle button event
        @Override
        public void actionPerformed(ActionEvent event)
        {
            // used to tell the paint method to draw certain things within the pain method
            if(!(game_started)) {
                word_to_guess = new String(guess_word_field.getPassword());
                guess_word_field.setEditable(false);
                word_to_guess = word_to_guess.toLowerCase();
                String wordToGuessWithoutSpaces = word_to_guess;
                wordToGuessWithoutSpaces = wordToGuessWithoutSpaces.replaceAll(" ", "");
                word_length = wordToGuessWithoutSpaces.length();
                game_started = true;
            }
            // repaint call preforms a request to redraw the component so that new things can be added
            repaint();
        }
    }
}