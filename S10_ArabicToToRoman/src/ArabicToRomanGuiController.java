
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Controller for the Arabic to Roman GUI
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ArabicToRomanGuiController {

    /**
     * Conversion class object used to perform the conversions
     */
    private static ArabicToRomanConversion conversion = new ArabicToRomanConversion();
    /**
     * Validator class object used to validate if roman number that is being converted is correct
     */
    private static RomanConversionValidator validator = new RomanConversionValidator();
    /**
     * arabic text area reference that can be used to access the arabic text area
     */
    @FXML
    private TextArea arabicTextField;

    /**
     * roman text area reference that can be used to access the roman text area
     */
    @FXML
    private TextArea romanTextField;

    /**
     * roman text label reference that can be used to access the roman text label
     */
    @FXML
    private Label romanText;

    /**
     * arabic text label reference that can be used to access the arabic text label
     */
    @FXML
    private Label arabicText;

    /**
     * validator label reference that can be used to access the validator label
     */
    @FXML
    private Label validatorLabel;

    /**
     * performs conversion when a key is types in the roman text area
     * @param e Keyevent object used to access info about the event
     */
    @FXML
    private void KeyTypedRoman(KeyEvent e)
    {
        if(validator.validateRomanConversion(romanTextField.getText().toUpperCase(), conversion))
        {
            arabicTextField.setText(conversion.RomanToArabic(romanTextField.getText().toUpperCase()));
            arabicTextField.positionCaret(arabicTextField.getLength());
            romanTextField.setText(conversion.ArabicToRoman(arabicTextField.getText()));
            romanTextField.positionCaret(romanTextField.getLength());
            validatorLabel.setText("Input Valid for Roman Text");
        }
        else
        {
            arabicTextField.setText("");
            romanTextField.setText("");
            validatorLabel.setText("Input Invalid for Roman Text: Please Re-enter");
        }

    }

    /**
     * performs conversion when a key is types in the arabic text area
     * @param e Keyevent object used to access info about the event
     */
    @FXML
    private void KeyTypedArabic(KeyEvent e)
    {
        if(Integer.parseInt(arabicTextField.getText()) <= 3999) {
            romanTextField.setText(conversion.ArabicToRoman(arabicTextField.getText()));
            romanTextField.positionCaret(romanTextField.getLength());
            arabicTextField.setText(conversion.RomanToArabic(romanTextField.getText().toUpperCase()));
            arabicTextField.positionCaret(arabicTextField.getLength());
        }
        else
        {
            arabicTextField.setText("");
            romanTextField.setText("");
            validatorLabel.setText("Input Invalid for Arabic Text: Please Re-enter");
        }
    }


    /**
     * called by FXMLLoader to initialize the controller
     */
    // called by FXMLLoader to initialize the controller
    public void initialize() {
    }
}