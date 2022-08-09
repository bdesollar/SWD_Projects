import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// used functionality from ch. 12 modules.

/**
 * Displays events on a GUI screen as the user performs actions
 * @author Ben DeSollar
 * @version 1.0, 8 October 2021
 */

public class DisplayEvents extends JFrame {

    /**
     * Text field on the JFrame
     */
    private final JTextField textField; // text field with text and size
    /**
     * An italic checkbox option on the JFrame
     */
    private final JCheckBox boldJCheckBox; // to select/deselect bold
    /**
     * A bold checkbox option on the JFrame
     */
    private final JCheckBox italicJCheckBox; // to select/deselect italic
    /**
     * A list field on the JFrame to display a color
     */
    private final JList<String> colorJList; // list to display colors
    /**
     * An array of type String that holds all the color names that the user can select
     */
    private final static String[] colorNames = {"Black", "Blue", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow"};
    /**
     * An Array of type Color that holds all the colors that the user can select
     */
    private final static Color[] colors = {Color.BLACK, Color.BLUE,
    Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
    Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW};
    /**
     * A JLabel that will display information to the user
     */
    private final JLabel statusBar; // displays event information
    /**
     * Line to store information for the first line of text area
     */
    private String line1 = ""; // first line of text area
    /**
     * Line to store information for the second line of text area
     */
    private String line2 = ""; // second line of text area
    /**
     * Line to store information for the third line of text area
     */
    private String line3 = ""; // third line of text area
    /**
     * Text area to display output of user actions
     */
    private final JTextArea textArea; // text area to display output


    /**
     * TextFieldFrame constructor that adds GUI options to JFrame
     */
    public DisplayEvents() {
        super("DisplayEvents");
        setLayout(new FlowLayout());

        statusBar = new JLabel("Mouse outside JPanel");
        add(statusBar, BorderLayout.SOUTH); // add label to JFrame


        // create and register listener for mouse and mouse motion events
        MouseHandler handlerMousePanel = new MouseHandler();
        addMouseListener(handlerMousePanel);
        addMouseMotionListener(handlerMousePanel);

        textArea = new JTextArea(); // set up JTextArea
        textArea.setText("Press any key on the keyboard...\n Testing");
        textArea.setEnabled(true);
        textArea.setSize(50, 50);
        textArea.setDisabledTextColor(Color.BLACK);
        add(textArea); // add text area to JFrame
        KeyHandler1 keyHandler1 = new KeyHandler1();
        textArea.addKeyListener(keyHandler1);


        colorJList = new JList<String>(colorNames); // list of colorNames
        colorJList.setVisibleRowCount(5); // display five rows at once
        // do not allow multiple selections
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // add a JScrollPane containing JList to frame
        add(new JScrollPane(colorJList));

        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox); // add bold checkbox to JFrame
        add(italicJCheckBox); // add italic checkbox to JFrame


        textField = new JTextField("Editable text field", 21);
        textField.setEditable(true); // disable editing
        add(textField); // add textField3 to JFrame

        TextFieldHandler handler = new TextFieldHandler();
        textField.addActionListener(handler);

        // register listeners for JCheckBoxes
        CheckBoxHandler handler_checkbox = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler_checkbox);
        italicJCheckBox.addItemListener(handler_checkbox);



        colorJList.addListSelectionListener(new ListSelectionListener() {
            /**
             * Sets the color of the screen to whatever the user selects on the color panel
             * @param e the event object of whatever the user did on the color panel
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
                System.out.println("Color of background has changed to " + colors[colorJList.getSelectedIndex()]);
            }
        });
    }

    /**
     * Handles the actions of when a key is pressed
     */
    private class KeyHandler1 implements KeyListener{
        /**
         * handles press of any key
         * @param event an object of the event of whatever action the user performed
         */
        @Override
        public void keyPressed(KeyEvent event)
        {
            line1 = String.format("Key pressed: %s",
                    KeyEvent.getKeyText(event.getKeyCode())); // show pressed key
            setLines2and3(event); // set output lines two and three
        }

        /**
         * Handle release of any key
         * @param event an object of the event of whatever action the user performed
         */
        // handle release of any key
        @Override
        public void keyReleased(KeyEvent event)
        {
            line1 = String.format("Key released: %s",
                    KeyEvent.getKeyText(event.getKeyCode())); // show released key
            setLines2and3(event); // set output lines two and three
        }

        /**
         * Handle press of an action key
         * @param event an object of the event of whatever action the user performed
         */
        // handle press of an action key
        @Override
        public void keyTyped(KeyEvent event)
        {
            line1 = String.format("Key typed: %s", event.getKeyChar());
            setLines2and3(event); // set output lines two and three
        }

        /**
         * Set second and third lines of output
         * @param event an object of the event of whatever action the user performed
         */
        // set second and third lines of output
        private void setLines2and3(KeyEvent event)
        {
            line2 = String.format("This key is %san action key",
                    (event.isActionKey() ? "" : "not "));

            String temp = KeyEvent.getKeyModifiersText(event.getModifiers());

            line3 = String.format("Modifier keys pressed: %s",
                    (temp.equals("") ? "none" : temp)); // output modifiers

            textArea.setText(String.format("%s\n%s\n%s\n",
                    line1, line2, line3)); // output three lines of text
            System.out.printf("%s\n%s\n%s\n",
                    line1, line2, line3);
        }

    }

    /**
     * Handles when the user moves the mouse on the JFrame
     */
    private class MouseHandler implements MouseListener, MouseMotionListener{
        // MouseListener event handlers

        /**
         * Handle event when mouse released immediately after press
         * @param e an object of the event of whatever action the user performed
         */
        // handle event when mouse released immediately after press
        @Override
        public void mouseClicked(MouseEvent e){
            statusBar.setText(String.format("Clicked at [%d, %d]", e.getX(), e.getY()));
            System.out.printf("Clicked at [%d, %d]\n", e.getX(), e.getY());
        }

        /**
         * Handles event when the mouse is pressed
         * @param e an object of the event of whatever action the user performed
         */
        @Override
        public void mousePressed(MouseEvent e){
            statusBar.setText(String.format("Pressed at [%d, %d]", e.getX(), e.getY()));
            System.out.printf("Pressed at [%d, %d]\n", e.getX(), e.getY());
        }

        /**
         * Handles event of the mouse being released
         * @param e an object of the event of whatever action the user performed
         */
        @Override
        public void mouseReleased(MouseEvent e){
            statusBar.setText(String.format("Released at [%d, %d]", e.getX(), e.getY()));
            System.out.printf("Released at [%d, %d]\n", e.getX(), e.getY());
        }

        /**
         * Handles event of when the mouse enters the JFrame
         * @param e an object of the event of whatever action the user performed
         */
        @Override
        public void mouseEntered(MouseEvent e){
            statusBar.setText(String.format("Mouse entered at [%d, %d]", e.getX(), e.getY()));
            System.out.printf("Mouse entered at [%d, %d]\n", e.getX(), e.getY());
        }

        /**
         * Handles the event of when the mouse exits the JFrame
         * @param e an object of the event of whatever action the user performed
         */
        @Override
        public void mouseExited(MouseEvent e){
            statusBar.setText("Mouse outside Panel");
            System.out.println("Mouse outside Panel\n");;
        }

        /**
         * Handles when the mouse is dragged across the JFrame
         * @param e an object of the event of whatever action the user performed
         */
        @Override
        public void mouseDragged(MouseEvent e){
            statusBar.setText(String.format("Dragged at [%d, %d]", e.getX(), e.getY()));
            System.out.printf("Dragged at [%d, %d]\n", e.getX(), e.getY());
        }

        /**
         * Handles when the mouse is moved across the JFrame
         * @param e an object of the event of whatever action the user performed
         */
        @Override
        public void mouseMoved(MouseEvent e){
            statusBar.setText(String.format("Moved at [%d, %d]", e.getX(), e.getY()));
            System.out.printf("Moved at [%d, %d]\n", e.getX(), e.getY());
        }


    }

    /**
     * Handles the checkbox on the JFrame
     */
    private class CheckBoxHandler implements ItemListener{

        /**
         * Handles when a box checkmark is changed
         * @param event an object of the event of whatever action the user performed
         */
        @Override
        public void itemStateChanged(ItemEvent event){
            Font font = null;

            if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected()){
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
                System.out.println("Bold check box and Italic check box have been selected");
            }
            else if(boldJCheckBox.isSelected()){
                font = new Font("Serif", Font.BOLD, 14);
                System.out.println("Bold check box has been selected");
            }
            else{;
                font = new Font("Serif", Font.ITALIC, 14);
                System.out.println("Italic check box has been selected");
            }
            textField.setFont(font);
        }
    }

    /**
     * Handles events that occur within the text field on the JFrame
     */
    // private inner class for event handling
    private class TextFieldHandler implements ActionListener{
        // process text field events

        /**
         * Handles any actions that the user performed in the Text field
         * @param event an object of the event of whatever action the user performed
         */
        @Override
        public void actionPerformed(ActionEvent event){
            String string = "";
            // user pressed Enter in JTextField textField1
            if(event.getSource() == textField){
                string = String.format("textField1: %s", event.getActionCommand());
                System.out.println(string);
            }

            JOptionPane.showMessageDialog(null, string);
        }

    }

}