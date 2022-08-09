/**
 * Validates that the roman conversion occurring is correct
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */


public class RomanConversionValidator {

    /**
     * validates the roman conversion occurring is correct
     * @param romanTextInputted roman text to validate
     * @param ar1 an object of class ArabicToRomanConversion to check the conversion in that class
     * @return true or false depending on if the roman conversion was valid
     */
    public boolean validateRomanConversion(String romanTextInputted, ArabicToRomanConversion ar1)
    {
        try{
            // checks to see if the process gives back something other than an empty string
            // if not than the conversion could not be completed
            String text = ar1.RomanToArabic(romanTextInputted);
            if(text.equals(""))
            {
                return false;
            }
            else
            {
                return true;
            }

        }catch(Exception e)
        {
            return false;
        }
    }
}
