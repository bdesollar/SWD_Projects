import java.util.ArrayList;


/**
 * Converts between both Roman and Arabic
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ArabicToRomanConversion {

    /**
     * a list of the roman characters for the thousands spot
     */
    private static final String[] conversionThousands = {"M", "MM", "MMM"};
    /**
     * a list of the roman characters for the hundreds spot
     */
    private static final String[] conversionHundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    /**
     * a list of the roman characters for the tens spot
     */
    private static final String[] conversionTens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    /**
     * a list of the roman characters for the ones spot
     */
    private static final String[] conversionUnits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    /**
     * the roman number during the conversion from Arabic numbers
     */
    private String currentRomanNumeral;


    /**
     * constructor initializes the current roman numeral to be an empty string
     */
    public ArabicToRomanConversion()
    {
        this.currentRomanNumeral = "";
    }

    /**
     * converts arabic numbers to roman
     * @param numberToConvert the arabic number to convert to Roman
     * @return the roman equivalent to the arabic number
     */
    public String ArabicToRoman(String numberToConvert)
    {
        currentRomanNumeral = "";
        String conversionNum = numberToConvert;
        // Checks if there needs to be a conversion from the thousands spot
        int lengthOfString = numberToConvert.length();
        if(lengthOfString == 4) {
            int firstNum = Integer.parseInt(String.valueOf(conversionNum.charAt(0)));
            int secondNum = Integer.parseInt(String.valueOf(conversionNum.charAt(1)));
            int thirdNum = Integer.parseInt(String.valueOf(conversionNum.charAt(2)));
            int fourthNum = Integer.parseInt(String.valueOf(conversionNum.charAt(3)));
            // Checks to make sure the number does not start with a zero
            if (firstNum != 0) {
                // has to minus one to get to the correct spot in the array
                currentRomanNumeral = conversionThousands[firstNum - 1];
            }
            if (secondNum != 0) {
                currentRomanNumeral += conversionHundreds[secondNum - 1];
            }
            if (thirdNum != 0) {
                currentRomanNumeral += conversionTens[thirdNum - 1];
            }
            if (fourthNum != 0) {
                currentRomanNumeral += conversionUnits[fourthNum - 1];
            }
        }
        else if(lengthOfString == 3) {
            int firstNum = Integer.parseInt(String.valueOf(conversionNum.charAt(0)));
            int secondNum = Integer.parseInt(String.valueOf(conversionNum.charAt(1)));
            int thirdNum = Integer.parseInt(String.valueOf(conversionNum.charAt(2)));
            if (firstNum != 0) {
                currentRomanNumeral += conversionHundreds[firstNum - 1];
            }
            if (secondNum != 0) {
                currentRomanNumeral += conversionTens[secondNum - 1];
            }
            if (thirdNum != 0) {
                currentRomanNumeral += conversionUnits[thirdNum - 1];
            }
        }
        else if(lengthOfString == 2) {
            int firstNum = Integer.parseInt(String.valueOf(conversionNum.charAt(0)));
            int secondNum = Integer.parseInt(String.valueOf(conversionNum.charAt(1)));
            if (firstNum != 0) {
                currentRomanNumeral += conversionTens[firstNum - 1];
            }
            if (secondNum != 0) {
                currentRomanNumeral += conversionUnits[secondNum - 1];
            }
        }
        else if(lengthOfString == 1) {
            int firstNum = Integer.parseInt(String.valueOf(conversionNum.charAt(0)));
            if (firstNum != 0) {
                currentRomanNumeral += conversionUnits[firstNum - 1];
            }
        }
        return currentRomanNumeral;
    }

    /**
     * converts from an roman number to an arabic number
     * @param numberToConvert the roman number to convert to arabic
     * @return the arabic equivalent to the roman number
     */
    public String RomanToArabic(String numberToConvert)
    {
        currentRomanNumeral = "";
        String temp = "";
        String currentConversionRomanNumeral = "";
        boolean hasThousands = false;
        boolean hasHundreds = false;
        boolean hasTens = false;
        boolean hasUnits = false;
        for(int i = 0; i < conversionThousands.length; i++)
        {
            // checks if the number contains a roman value in the thousands
            if(numberToConvert.contains(conversionThousands[i]))
            {
                currentConversionRomanNumeral = String.valueOf(i + 1);
                temp = conversionThousands[i];
                hasThousands = true;
            }
        }
        currentRomanNumeral += currentConversionRomanNumeral;
        numberToConvert = numberToConvert.substring(temp.length());
        temp = "";
        for(int i = 0; i < numberToConvert.length(); i++)
        {
            // gets the number up until it reaches the hundreds spot
            if(numberToConvert.charAt(i) != 'X' && numberToConvert.charAt(i) != 'L' && numberToConvert.charAt(i) != 'I' && numberToConvert.charAt(i) != 'V')
            {
                temp += numberToConvert.charAt(i);
            }
            else
            {
                break;
            }
        }
        for(int i = 0; i < conversionHundreds.length; i++)
        {
            // checks if the current temp string has a character or characters in the hundreds spot
            if(conversionHundreds[i].equals(temp))
            {
                currentConversionRomanNumeral = String.valueOf(i + 1);
                hasHundreds = true;
            }
        }
        // if the number has a thousands spot and not a hundfreds spot than tyhe
        if(hasThousands && !(hasHundreds))
        {
            currentConversionRomanNumeral = "0";
            hasHundreds = true;
        }
        else
        {
            numberToConvert = numberToConvert.substring(temp.length());
        }
        currentRomanNumeral += currentConversionRomanNumeral;
        temp = "";
        for(int i = 0; i < numberToConvert.length(); i++)
        {
            if(numberToConvert.charAt(i) != 'I' && numberToConvert.charAt(i) != 'V' )
            {
                temp += numberToConvert.charAt(i);
            }
            else
            {
                break;
            }
        }
        for(int i = 0; i < conversionTens.length; i++)
        {
            if(conversionTens[i].equals(temp))
            {
                currentConversionRomanNumeral = String.valueOf(i + 1);
                hasTens = true;
            }
        }
        if(hasHundreds && !(hasTens))
        {
            currentConversionRomanNumeral = "0";
            hasTens = true;
        }
        else
        {
            numberToConvert = numberToConvert.substring(temp.length());
        }
        currentRomanNumeral += currentConversionRomanNumeral;
        for(int i = 0; i < conversionUnits.length; i++)
        {
            if(conversionUnits[i].equals(numberToConvert))
            {
                currentConversionRomanNumeral = String.valueOf(i + 1);
                hasUnits = true;
            }
        }
        if(hasTens && !(hasUnits))
        {
            currentConversionRomanNumeral = "0";
            hasUnits = true;
        }
        currentRomanNumeral += currentConversionRomanNumeral;
        return currentRomanNumeral;
    }
}
